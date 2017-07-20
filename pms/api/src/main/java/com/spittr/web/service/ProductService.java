package com.spittr.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spittr.web.bean.Product;
import com.spittr.web.repository.jpa.ProductRepository;

/**
 * @author Vinayak More
 *
 * @date 17-Jul-2017
 */
@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        super();
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public List<Product> getProductBySellerId(long sellerId) {
        return repository.findBySellerId(sellerId);

    }

    public Product getProductById(long productId) {
        return repository.findOne(productId);
    }
    
    public List<Product> getProductsByName(String productName){
        return repository.findByNameContaining(productName);
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public void delete(Product product) {
        repository.delete(product);
    }
}
