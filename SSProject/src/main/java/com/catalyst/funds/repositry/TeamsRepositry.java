package com.catalyst.funds.repositry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.catalyst.funds.entity.TeamsEntity;


public interface TeamsRepositry extends CrudRepository<TeamsEntity, Integer> {
	
	TeamsEntity findByTeamName(String teamName);
	List <TeamsEntity> findByUserEntities_UserName(String userName);
	
}

