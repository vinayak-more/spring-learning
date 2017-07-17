package product;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spittr.config.PersistenceContext;
import com.spittr.config.RootConfig;
import com.spittr.web.bean.Product;
import com.spittr.web.repository.impl.jpa.ProductRepository;
import com.spittr.web.service.ProductService;
import com.spittr.webapi.controller.ProductController;

/**
 * @author Vinayak More
 *
 * @date 17-Jul-2017
 */
@ContextConfiguration(classes = {RootConfig.class, PersistenceContext.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductTest {

    @Autowired
    ProductService service;

    @Test
    public void shouldNotBeNull() {
        Assert.assertNotNull(service);
    }

    @Test
    public void getProductsBySellerId() {
        List<Product> productList = service.getProductBySellerId(1L);
        System.out.println(productList);
        Assert.assertNotNull(productList);
    }
    @Ignore
    @Test
    public void saveAndDeleteProduct() {
        Product product = getTestProduct();
        Product productEntity = service.save(product);
        System.out.println("**********************************");
        System.out.println("Product Entity=" + productEntity);
        Assert.assertNotNull(productEntity);
        service.delete(productEntity);
        Assert.assertNull(service.getProductById(productEntity.getId()));
    }
    
    @Test
    public void updateProduct(){
        Product product=service.getProductById(1);
        product.setName(product.getName()+" updated");
        Product productEntity = service.save(product);
        System.out.println("**********************************");
        System.out.println("Product Entity=" + productEntity);
        Assert.assertNotNull(productEntity);
    }



    private Product getTestProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(2500);
        product.setSellerId(1L);
        product.setHeight(5);
        return product;
    }

    public void testProductBySellerId() throws Exception {
        // mocks
        List<Product> expectedSpittles = getInMemoryProducts();
        ProductRepository repository = Mockito.mock(ProductRepository.class);
        Mockito.when(repository.findBySellerId(1L)).thenReturn(expectedSpittles);
        ProductService service = new ProductService(repository);

        ProductController controller = new ProductController(service);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/bysellerid/1")).andExpect(
                MockMvcResultMatchers.model().attribute("productList", Matchers.hasItems(expectedSpittles.toArray())));;
    }

    protected List<Product> getInMemoryProducts() {
        List<Product> products = new ArrayList<Product>();
        for (long i = 0; i < 5; i++) {
            Product product = new Product();
            product.setId(i);
            product.setSellerId(1L);
            product.setName("Product " + i);
            product.setPrice(i * 1000);
            products.add(product);
        }
        return products;
    }
}
