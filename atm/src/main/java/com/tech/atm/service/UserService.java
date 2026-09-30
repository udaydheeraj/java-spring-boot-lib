package com.tech.atm.service;

import com.tech.atm.dto.UserRequest;
import com.tech.atm.dto.UserResponse;
import com.tech.atm.entity.User;

import java.util.List;

public interface UserService {

    UserResponse CreateUser(UserRequest userRequest);

    UserResponse getById(Integer id);

    List<UserResponse> getAllUsers();

    User UpdateUser(Integer id, User user);

    void DeleteUser(Integer id);

}
