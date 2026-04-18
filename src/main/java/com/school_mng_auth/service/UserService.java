package com.school_mng_auth.service;

import com.school_mng_auth.dto.LoginRequest;
import com.school_mng_auth.dto.RegisterRequest;
import com.school_mng_auth.entity.User;

public interface UserService {

    public String register(RegisterRequest user);
    public String login(LoginRequest user);

}
