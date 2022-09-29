package com.catalyst.funds.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.catalyst.funds.entity.UserEntity;

public interface UserRepositry extends CrudRepository<UserEntity,Long> {
	
	UserEntity findByUserName(String userName);
	
}
