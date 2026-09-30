package com.tech.atm.service;

import com.tech.atm.dto.UserRequest;
import com.tech.atm.dto.UserResponse;
import com.tech.atm.entity.User;
import com.tech.atm.exception.UserNotFoundException;
import com.tech.atm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public  UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserResponse CreateUser(UserRequest user) {

        User entity = User.builder()
                .userName(user.getUserName())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .userStatus(User.UserStatus.ACTIVE)
                .build();
       User createdUser = userRepository.save(entity);
       return UserResponse.builder()
               .userId(createdUser.getUserId())
               .userName(createdUser.getUserName())
               .fullName(createdUser.getFullName())
               .email(createdUser.getEmail())
               .phoneNumber(createdUser.getPhoneNumber())
               .status(createdUser.getUserStatus())
               .build();

    }

    @Override
    public UserResponse getById(Integer id) {
        User user =  userRepository.findById(id).orElseThrow(() ->
                new UserNotFoundException("User not found with id: " + id));
        return UserResponse.builder()
                .userName(user.getUserName())
                .fullName(user.getFullName())
                .userId(user.getUserId())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getUserStatus())
                .build();
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users =  userRepository.findAll();

        return users.stream()
                .map(user -> UserResponse.builder()
                        .userName(user.getUserName())
                        .userId(user.getUserId())
                        .fullName(user.getFullName())
                        .email(user.getEmail())
                        .phoneNumber(user.getPhoneNumber())
                        .status(user.getUserStatus())
                        .build()).toList();
    }

    @Override
    @Transactional
    public User UpdateUser(Integer id, User userDetails) {
        /*User existingUser = getById(id);

      *//*  if(!existingUser.getEmail().equalsIgnoreCase(userDetails.getEmail()) &&
                !userRepository.exitsByEmail(userDetails.getEmail()))
        {
            throw new RuntimeException("Email already in use by another user: " + userDetails.getEmail());
        }*//*


            // Update allowed fields
            existingUser.setFullName(userDetails.getFullName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPhoneNumber(userDetails.getPhoneNumber());
            return userRepository.save(existingUser);*/
        return null;

    }

    @Override
    public void DeleteUser(Integer id) {
        /*User existingUser = getById(id);
        userRepository.delete(existingUser);*/

    }
}
