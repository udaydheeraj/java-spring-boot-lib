package com.tech.atm.dto;

import com.tech.atm.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Integer userId;
    private String userName;
    private String fullName;
    private String email;
    private String phoneNumber;
    private User.UserStatus status;
}
