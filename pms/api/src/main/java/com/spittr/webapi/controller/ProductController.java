package com.spittr.webapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spittr.web.bean.Product;
import com.spittr.web.service.ProductService;

/**
 * @author Vinayak More
 *
 * @date 17-Jul-2017
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }



    @RequestMapping(value = "/bysellerid/{sellerId}", method = RequestMethod.GET)
    public @ResponseBody List<Product> getProductsBySellerId(@PathVariable Long sellerId, Model model) {
        List<Product> productBySellerId = service.getProductBySellerId(sellerId);
        model.addAttribute("productList", productBySellerId);
        return productBySellerId;
    }
}
