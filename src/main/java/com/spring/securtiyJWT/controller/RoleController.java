package com.spring.securtiyJWT.controller;

import com.spring.securtiyJWT.entity.Role;
import com.spring.securtiyJWT.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/createNewRole")
    public ResponseEntity<Role> createNewRole(@RequestBody Role role)
    {
        return new ResponseEntity<>(roleService.createNewRole(role), HttpStatus.OK);

    }


}
