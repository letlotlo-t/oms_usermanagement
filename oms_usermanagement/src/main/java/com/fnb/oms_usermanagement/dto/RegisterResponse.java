package com.fnb.oms_usermanagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {
    private Long customerId;
    private String firstName;
    private String surname;
    private String email;
    private String role;
}