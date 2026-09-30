package com.tech.atm.dto;

import com.tech.atm.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "UserName cannot be empty")
     String userName;

    @NotBlank(message = "UserName cannot be empty")
    String fullName;

    @NotBlank(message = "Email is required" )
    @Email(message = "Invalid Email format")
     String email;

    @NotBlank(message = "UserName cannot be empty")
    String phoneNumber;

}
