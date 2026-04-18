package com.school_mng_auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {

    private String name;
    private String email;
    private String password;
    private String role;
}
