package com.spring.securtiyJWT.controller;

import com.spring.securtiyJWT.entity.UserTable;
import com.spring.securtiyJWT.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostConstruct
    public void initRolesAndUser()
    {
        userService.initRolesAndUser();

    }

    @PostMapping
    public ResponseEntity<UserTable>registerNewUser(@RequestBody UserTable user)
    {
        return ResponseEntity.ok(userService.registerNewUser(user));

    }


}
