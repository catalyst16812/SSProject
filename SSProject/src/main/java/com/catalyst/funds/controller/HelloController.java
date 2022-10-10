package com.catalyst.funds.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.funds.TeamWithUser;
import com.catalyst.funds.Teams;
import com.catalyst.funds.User;
import com.catalyst.funds.entity.TeamsEntity;
import com.catalyst.funds.entity.UserEntity;
import com.catalyst.funds.entity.PaymentEntity;
import com.catalyst.funds.repositry.PaymentRepositry;
import com.catalyst.funds.repositry.TeamsRepositry;
import com.catalyst.funds.repositry.UserRepositry;
import com.catalyst.funds.security.UserPrinciple;

@RestController
public class HelloController {
@Autowired
private UserRepositry userVar;
@Autowired
private TeamsRepositry teamVar;
@Autowired
private PaymentRepositry payVar;
@Autowired
private PasswordEncoder passVar;


	@GetMapping("/userinfo")
	public List<User> index() {
		Iterable<UserEntity> users = userVar.findAll();
		System.out.println(users);
		List<User> userlist = new ArrayList<>();
		
		for (UserEntity userEntity : users) {
			User u = new User();
			u.setUserName(userEntity.getUserName());
			u.setUserId(userEntity.getUserId());
			u.setPhoneNo(userEntity.getPhoneNo());
			u.setEmail(userEntity.getEmail());
			
			userlist.add(u);
		}
		return userlist;
		
	}
	
	@GetMapping("/getrole")
	public String getrole()
	{
		UserPrinciple principal = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return principal.getRole();
	}
	
	@GetMapping("/teaminfo")
	public List<Teams> info() {
		UserPrinciple principal = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(principal.getRole()+" "+principal.getUsername());
		Iterable<TeamsEntity> team;
		if(principal.getRole().equalsIgnoreCase("admin")) 
		{
			team = teamVar.findAll();	
		}
		else
			team = teamVar.findByUserEntities_UserName(principal.getUsername());
		System.out.println(team);
		List<Teams> teamlist = new ArrayList<>();
		
		for (TeamsEntity teamEntity : team) {
			Teams t = new Teams();
			
			
			t.setTeamId(teamEntity.getTeamId());
			t.setTeamName(teamEntity.getTeamName());
			t.setFundGoal(teamEntity.getFundGoal());
			t.setCycle(teamEntity.getCycle());
			
			teamlist.add(t);
		}
		return teamlist;
		
	}
	
	@PostMapping (path="/userdata")
	public User alt(@RequestBody User U) {
		System.out.println(U);
		UserEntity entity = new UserEntity();
		//entity.setUserId(U.getUserId());
		entity.setUserName(U.getUserName());
		entity.setEmail(U.getEmail());
		entity.setPhoneNo(U.getPhoneNo());
		entity.setPassword(passVar.encode(U.getPassword()));
		userVar.save(entity);
		return U;
	}
	   @PostMapping (path="/signupuser")
	    public User alt2(@RequestBody User U) {
	        System.out.println(U);
	        UserEntity entity = new UserEntity();
	        //entity.setUserId(U.getUserId());
	        entity.setUserName(U.getUserName());
	        entity.setEmail(U.getEmail());
	        entity.setPhoneNo(U.getPhoneNo());
	        entity.setPassword(passVar.encode(U.getPassword()));
	        userVar.save(entity);
	        return U;
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
	
	
	@PutMapping (path="/teamsdata")
	public String update(@RequestBody TeamWithUser T) {
		System.out.println(T);
		TeamsEntity teamsOption = teamVar.findByTeamName(T.getTeamname());
	
			UserEntity userOption = userVar.findByUserName(T.getUsername());
			teamsOption.getUserEntities().add(userOption);
		
		teamVar.save(teamsOption);
		return T.toString();
		
    }

	@DeleteMapping(path="/teamsdata")
	public String deleteUserFromTeam(@RequestBody TeamWithUser T)
	{
		System.out.println(T);
		
		UserEntity userOption = userVar.findByUserName(T.getUsername());
		TeamsEntity teamsOption = teamVar.findByTeamName(T.getTeamname());
		
		teamsOption.getUserEntities().remove(userOption);
		
		teamVar.save(teamsOption);
		return null;
		
	}
	
	@DeleteMapping(path="/teamsdelete/{id}")
	public String deleteTeam(@PathVariable Integer id)
	{
	
		Optional<TeamsEntity> teamsOption = teamVar.findById(id);
		if(teamsOption.isPresent()) {
			teamVar.delete(teamsOption.get());
		}
		
		return null;
		
	}
	
	@DeleteMapping(path="/deletetxn/{id}")
	public String deleteTxn(@PathVariable Integer id)
	{
	
		Optional<PaymentEntity> payment = payVar.findById(id);
		if(payment.isPresent()) {
			payVar.delete(payment.get());
		}
		
		return null;
		
	}
}