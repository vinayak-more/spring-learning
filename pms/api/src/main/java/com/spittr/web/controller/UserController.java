package com.spittr.web.controller;

import javax.validation.Valid;

import com.spittr.web.bean.User;
import com.spittr.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vinayak More
 *
 * @date 21-Jul-2017
 */
@Controller
@RequestMapping("/users")
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
        return "usersfiltered";
    }

    @RequestMapping(value = "/search/name/{name}", method = RequestMethod.GET)
    public String getAllUserByName(@PathVariable String name, Model model) {
        model.addAttribute("userList", service.searchUsersByName(name));
        return "usersfiltered";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid User user, Errors errors) {
        System.out.println(user);
        System.out.println(errors);
        if (errors.hasErrors()) {
            return "adduser";
        }
        service.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/edit/{userId}", method = RequestMethod.GET)
    public String editUserForm(@PathVariable Long userId, Model model) {
        User user = service.getUserById(userId);
        model.addAttribute("user", user);
        return "edituser";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@Valid User user, Errors errors) {
        System.out.println(user);
        System.out.println(errors);
        if (errors.hasErrors()) {
            return "edituser";
        }
        service.save(user);
        return "redirect:/users";
    }
}
