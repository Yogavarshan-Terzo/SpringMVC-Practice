package com.rungroop.web.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegistrationDto {
    private Long id;
    @NotEmpty(message = "Username cannot be empty")
    private String userName;
    @NotEmpty(message = "Email cannot be empty")

    private String email;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
