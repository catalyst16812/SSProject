package com.catalyst.funds.repositry;

import java.util.List;

import com.catalyst.funds.User;
import com.catalyst.funds.entity.UserEntity;

public interface UserService {
    void saveUser(User userDto);

    List<User> findAllUsers();

	UserEntity findUserByUsername(String username);
}