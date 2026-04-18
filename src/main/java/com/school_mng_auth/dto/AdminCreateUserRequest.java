package com.school_mng_auth.dto;

import com.school_mng_auth.utility.Role;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminCreateUserRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
