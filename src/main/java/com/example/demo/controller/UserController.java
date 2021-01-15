package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.dao.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String getBrandList() {
        LOGGER.info("request hit / method");
        return "hello";
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable int id) {
        User user = userService.Select(id);
        if (null == user) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find user with id[" + id + "]");
        }
        return user;
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    @ResponseBody
    public String getUser(@RequestBody String data) {
        return data;
    }
    
    @RequestMapping(value = "users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUser() {
        return userService.selectAll();
    }

}