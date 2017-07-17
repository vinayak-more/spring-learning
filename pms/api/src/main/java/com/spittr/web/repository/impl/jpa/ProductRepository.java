package com.spittr.web.repository.impl.jpa;

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
}

