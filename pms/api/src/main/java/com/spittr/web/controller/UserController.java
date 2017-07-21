package com.spittr.web.controller;

import com.spittr.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vinayak More
 *
 * @date 21-Jul-2017
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("userList", service.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/search/sellerid/{sellerId}", method = RequestMethod.GET)
    public String getAllUserBySellerId(@PathVariable Long sellerId, Model model) {
        model.addAttribute("userList", service.getAllUsersBySellerId(sellerId));
        return "users";
    }

    @RequestMapping(value = "/search/name/{name}", method = RequestMethod.GET)
    public String getAllUserByName(@PathVariable String name, Model model) {
        model.addAttribute("userList", service.searchUsersByName(name));
        return "users";
    }
    
    
}
