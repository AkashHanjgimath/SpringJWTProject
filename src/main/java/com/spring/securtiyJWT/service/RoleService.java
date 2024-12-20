package com.spring.securtiyJWT.service;

import com.spring.securtiyJWT.entity.Role;
import com.spring.securtiyJWT.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public Role createNewRole(Role role)
    {
        return roleRepository.save(role);
    }
}
