package com.spittr.web.repository.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spittr.web.bean.Product;

/**
 * @author Vinayak More
 *
 * @date 17-Jul-2017
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

    public List<Product> findBySellerId(Long sellerId);
    
    public List<Product> findAll();
    
    public List<Product> findByNameContaining(String Name);

    public Product findByProductId(String productId);
    
}

