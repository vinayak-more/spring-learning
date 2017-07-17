package com.spittr.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spittr.web.bean.User;
import com.spittr.web.repository.jpa.UserRepository;

/**
 * @author Vinayak More
 *
 * @date 17-Jul-2017
 */
@Service
public class UserService {

    UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserById(long userId) {
        return repository.findOne(userId);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(User user) {
        repository.delete(user);
    }

    public List<User> getUserByName(String name) {
        return repository.getUserByName(name);
    }

}
