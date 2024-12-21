package com.practice.todo_list.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.RestController;

import com.practice.todo_list.model.User;
import com.practice.todo_list.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @RestController tag handles HTTP requests and gives back responses
 * 
 * Controllers are mapped to specific URLs that use annotations:
 *      - @RequestMapping
 *      - @GetMapping
 *      - @PostMapping
 *      - @PutMapping
 *      - @DeleteMapping
 * 
 * Also allows dependency injection!
*/

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth/user")
    public User getAuthenticatedUser(Principal principal, OAuth2User oauth2User) {
        String email = oauth2User.getAttribute("email");
        String name = oauth2User.getAttribute("name");

        return userService.getOrCreateUser(email, name);
    }
    

}