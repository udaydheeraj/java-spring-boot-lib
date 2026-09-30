package com.tech.atm.repository;

import com.tech.atm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUserName(String username);

    User findUserByEmail(String email);

    //boolean existsByUsername(String userName);

   // boolean exitsByEmail(String email);
}
