package com.catalyst.funds.controller;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.catalyst.funds.Payment;
import com.catalyst.funds.Teams;
import com.catalyst.funds.User;
import com.catalyst.funds.entity.TeamsEntity;
import com.catalyst.funds.entity.UserEntity;
import com.catalyst.funds.entity.PaymentEntity;
import com.catalyst.funds.repositry.PaymentRepositry;
import com.catalyst.funds.repositry.TeamsRepositry;
import com.catalyst.funds.repositry.UserRepositry;

@Controller
public class HelloController {
@Autowired
private UserRepositry userVar;
@Autowired
private TeamsRepositry teamVar;
@Autowired
private PaymentRepositry payVar;


	@GetMapping("/page1/{var1}")
	public String index(@PathVariable String var1) {
		Iterable<UserEntity> users = userVar.findAll();
		System.out.println(users);
		return "This is page 1"+var1;
		
	}
	@PostMapping (path="/userdata")
	public String alt(@RequestBody User U) {
		System.out.println(U);
		UserEntity entity = new UserEntity();
		//entity.setUserId(U.getUserId());
		entity.setUserName(U.getUserName());
		entity.setEmail(U.getEmail());
		entity.setPhoneNo(U.getPhoneNo());

		userVar.save(entity);
		return U.toString();
	}
	@PostMapping (path="/teamsdata")
	public String alt(@RequestBody Teams T) {
		System.out.println(T);
		TeamsEntity tent = new TeamsEntity();
		//tent.setTeamId(T.getTeamId());
		tent.setTeamName(T.getTeamName());
		tent.setFundGoal(T.getFundGoal());
		tent.setCycle(T.getCycle());
		Set<UserEntity> userEntities = new HashSet<>();
		UserEntity entity = userVar.findByUserName(T.getUserName());
		userEntities.add(entity);
		tent.setUserEntities(userEntities);
		
		teamVar.save(tent);
		return T.toString();
	}
	
	@PostMapping (path="/payments")
	public String alt(@RequestBody Payment P) {
		System.out.println(P);
		PaymentEntity pay = new PaymentEntity();
		pay.setAmount(P.getAmount());
		pay.setDate(P.getDate());
		pay.setTxnId(P.getTxnId());
		
		Set<TeamsEntity> teamsEntities = new HashSet<>();
		TeamsEntity entity = teamVar.findByTeamName(P.getTeamId());
		//entity.getUserEntities().add(null)
		teamsEntities.add(entity);
		pay.setTeamsEntities(teamsEntities);
		
		Set<UserEntity> userEntities = new HashSet<>();
		UserEntity entity2 = userVar.findByUserName(P.getUserName());
		userEntities.add(entity2);
		pay.setUserEntities(userEntities);
		
		payVar.save(pay);
		return P.toString();
		
	}

}