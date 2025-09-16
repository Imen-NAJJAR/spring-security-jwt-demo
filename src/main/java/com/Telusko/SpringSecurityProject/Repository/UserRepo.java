package com.Telusko.SpringSecurityProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.Telusko.SpringSecurityProject.model.Users;
@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUserName(String username);
}
