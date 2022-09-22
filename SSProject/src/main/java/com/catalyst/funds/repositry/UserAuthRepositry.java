package com.catalyst.funds.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import com.catalyst.funds.security.UserAuth;

public interface UserAuthRepositry extends JpaRepository<UserAuth, Long> {

	UserAuth findByUsername(String username); 
}
