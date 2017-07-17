package com.spittr.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spittr.web.bean.Product;
import com.spittr.web.repository.impl.jpa.ProductRepository;

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



    public List<Product> getProductBySellerId(long sellerId) {
        return repository.findBySellerId(sellerId);

    }
}
