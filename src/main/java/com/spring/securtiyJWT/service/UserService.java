package com.spring.securtiyJWT.service;


import com.spring.securtiyJWT.entity.Role;
import com.spring.securtiyJWT.entity.UserTable;
import com.spring.securtiyJWT.repository.RoleRepository;
import com.spring.securtiyJWT.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public UserTable registerNewUser(UserTable user)
    {
        return userRepository.save(user) ;

    }

    public void initRolesAndUser()
    {
        Role adminRole=new Role();
        adminRole.setRoleName("ADMIN");
        adminRole.setRoleDescription("Admin Role");
        roleRepository.save(adminRole);

        Role userRole =new Role();
        userRole.setRoleName("USER");
        userRole.setRoleDescription("Default record for the newly created Role");
        roleRepository.save(userRole);


        UserTable adminUser=new UserTable();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserpassword("admin@12");
        Set<Role>adminRoles=new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        userRepository.save(adminUser);

        UserTable user=new UserTable();
        user.setUserFirstName("Akash");
        user.setUserLastName("HM");
        user.setUserName("AkashHM");
        user.setUserpassword("akash@12");
        Set<Role>userRoles=new HashSet<>();
        userRoles.add(userRole);
        user.setRoles(userRoles);
        userRepository.save(user);





    }
}
