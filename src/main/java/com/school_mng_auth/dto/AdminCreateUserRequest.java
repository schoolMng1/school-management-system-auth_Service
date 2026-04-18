package com.school_mng_auth.dto;

import com.school_mng_auth.utility.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminCreateUserRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
