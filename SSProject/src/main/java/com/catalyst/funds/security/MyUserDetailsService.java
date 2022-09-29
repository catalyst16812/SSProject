package com.catalyst.funds.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.catalyst.funds.entity.UserEntity;
import com.catalyst.funds.repositry.UserAuthRepositry;

 
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserAuthRepositry repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		UserEntity user = repo.findByUserName(username);
		if(user==null)
			throw new UsernameNotFoundException("User 404 not found");
		//return	User.withUsername(user.getUsername()).password(user.getPassword()).build();
			
		return new UserPrinciple(user);
	}
	
	

}
