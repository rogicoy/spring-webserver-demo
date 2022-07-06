package com.demo.webserverdemo.controller;

import com.demo.webserverdemo.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    // @GetMapping("/user")
    @GetMapping
    public User getUser(
            @RequestParam(value = "firstname", defaultValue = "Rogeno") String firstname,
            @RequestParam(value = "lastname", defaultValue = "Icoy") String lastname,
            @RequestParam(value = "age", defaultValue = "33") int age) {
        User user = new User();

        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);

        return user;
    }

    // @GetMapping
    // @RequestMapping("{firstname}/{lastname}")
    @GetMapping("{firstname}/{lastname}")
    public User getUser2( @PathVariable String firstname, @PathVariable String lastname ) {
        User user = new User();

        user.setFirstname(firstname);
        user.setLastname(lastname);

        return user;
    }
}
