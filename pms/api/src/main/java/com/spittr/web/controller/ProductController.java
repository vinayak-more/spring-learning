package com.spittr.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public String getProductById(@PathVariable long productId, Model model) {
        model.addAttribute("product", service.getProductById(productId));
        return "product";
    }


    @RequestMapping(value = "/search/{productName}", method = RequestMethod.GET)
    public String searchProductByName(@PathVariable String productName, Model model) {
        model.addAttribute("productList", service.getProductsByName(productName));
        return "product-found";
    }
    
}
