package com.Telusko.SpringSecurityProject.Service;

import com.Telusko.SpringSecurityProject.Repository.UserRepo;
import com.Telusko.SpringSecurityProject.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.remote.JMXAuthenticator;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JWTokenService jwTokenService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public Users regiter( Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        if(authentication.isAuthenticated())
            return jwTokenService.generateToken(user.getUserName());
        return "Fail!!!";
    }
}
