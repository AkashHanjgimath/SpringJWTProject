package com.spring.securtiyJWT.repository;


import com.spring.securtiyJWT.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTable,String> {
}
