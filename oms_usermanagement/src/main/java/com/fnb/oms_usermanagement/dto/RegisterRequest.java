package com.fnb.oms_usermanagement.dto;

import com.fnb.oms_usermanagement.entity.Role;
import lombok.*;

@Data
public class RegisterRequest {
    private String firstName;
    private String surname;
    private String email;
    private Role role;
    private String password;
}