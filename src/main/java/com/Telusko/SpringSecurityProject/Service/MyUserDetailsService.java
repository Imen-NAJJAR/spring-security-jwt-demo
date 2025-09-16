package com.Telusko.SpringSecurityProject.Service;

import com.Telusko.SpringSecurityProject.Repository.UserRepo;
import com.Telusko.SpringSecurityProject.model.UserPrincipal;
import com.Telusko.SpringSecurityProject.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    public MyUserDetailsService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUserName(username);

        if (user == null ){
            System.out.println("User not found !");
            throw new UsernameNotFoundException("User not found ! ");
        }


        return new UserPrincipal(user);
    }
}
