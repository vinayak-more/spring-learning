package com.spittr.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spittr.web.bean.Product;
import com.spittr.web.service.ProductService;

/**
 * @author Vinayak More
 *
 * @date 20-Jul-2017
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        super();
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("productList", service.getAllProducts());
        return "products";
    }

    @RequestMapping(value = "/byId/{productId}", method = RequestMethod.GET)
    public String getProductById(@PathVariable String productId, Model model) {
        model.addAttribute("product", service.getProductByProductId(productId));
        return "product";
    }


    @RequestMapping(value = "/search/{productName}", method = RequestMethod.GET)
    public String searchProductByName(@PathVariable String productName, Model model) {
        model.addAttribute("productList", service.getProductsByName(productName));
        return "product-found";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProduct(@Valid Product product, Errors errors) {
        System.out.println(product);
        System.out.println(errors);
        if (errors.hasErrors()) {
            return "addProduct";
        }
        service.save(product);
        return "redirect:/products";
    }

}
