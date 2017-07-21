package com.spittr.web.repository.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spittr.web.bean.User;


/**
 * @author Vinayak More
 *
 * @date 17-Jul-2017
 */
public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> getUserByName(String name);
    
    public List<User> getUserByNameContaining(String name);
    
    public List<User> getUserBySellerId(Long sellerId);
    
    public List<User> findAll();
}

