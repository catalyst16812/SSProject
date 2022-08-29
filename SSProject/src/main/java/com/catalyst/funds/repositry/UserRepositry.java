package com.catalyst.funds.repositry;

import org.springframework.data.repository.CrudRepository;

import com.catalyst.funds.entity.UserEntity;

public interface UserRepositry extends CrudRepository<UserEntity,Integer> {
	
	UserEntity findByUserName(String userName);
	
}
