package com.school_mng_auth.service;

import com.school_mng_auth.dto.LoginRequest;
import com.school_mng_auth.dto.RegisterRequest;
import com.school_mng_auth.entity.User;
import com.school_mng_auth.repositiry.UserRepo;
import com.school_mng_auth.utility.Role;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

    private PasswordEncoder passwordEncoder;

//    @Autowired
//    public UserServiceImpl(UserRepo userRepo){
//        this.userRepo=userRepo;
//    }
    @Override
    public String register(RegisterRequest registerRequest) {

        User user = User.builder()
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.ROLE_STUDENT)
                .name(registerRequest.getName())
                .build();

        userRepo.save(user);

        return "User registered successfully";
    }

    @Override
    public String login(LoginRequest request) {

        User user = userRepo.findByEmail(request.getEmail()).orElseThrow(
                () -> new RuntimeException("User not found!")
        );

        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw  new RuntimeException("Wrong password!");
        }

        return "Logged in successfully";
    }
}
