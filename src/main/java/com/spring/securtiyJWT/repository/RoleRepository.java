package com.spring.securtiyJWT.repository;

import com.spring.securtiyJWT.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
}
