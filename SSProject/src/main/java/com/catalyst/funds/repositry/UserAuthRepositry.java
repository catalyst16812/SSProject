package com.catalyst.funds.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.catalyst.funds.entity.UserEntity;

public interface UserAuthRepositry extends JpaRepository<UserEntity, Long> {

	UserEntity findByUserName(String username); 
}
