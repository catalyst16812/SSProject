package com.catalyst.funds.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface UserAuthRepositry extends JpaRepository<User, Long> {

	User findByUsername(String username); 
}
