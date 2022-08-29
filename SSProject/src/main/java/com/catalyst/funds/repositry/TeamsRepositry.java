package com.catalyst.funds.repositry;

import org.springframework.data.repository.CrudRepository;

import com.catalyst.funds.entity.TeamsEntity;


public interface TeamsRepositry extends CrudRepository<TeamsEntity, Integer> {
	
}

