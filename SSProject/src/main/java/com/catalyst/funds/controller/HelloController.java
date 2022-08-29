package com.catalyst.funds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.catalyst.funds.Teams;
import com.catalyst.funds.User;
import com.catalyst.funds.entity.TeamsEntity;
import com.catalyst.funds.entity.UserEntity;
import com.catalyst.funds.repositry.TeamsRepositry;
import com.catalyst.funds.repositry.UserRepositry;

@Controller
public class HelloController {
@Autowired
private UserRepositry userVar;
@Autowired
private TeamsRepositry teamVar;


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

		teamVar.save(tent);
		return T.toString();
	}
	

}