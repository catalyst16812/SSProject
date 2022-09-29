package com.catalyst.funds.security;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.catalyst.funds.User;
import com.catalyst.funds.entity.RoleEntity;
import com.catalyst.funds.entity.UserEntity;

import com.catalyst.funds.repositry.RoleRepository;
import com.catalyst.funds.repositry.UserRepositry;
import com.catalyst.funds.repositry.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepositry userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepositry userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(User userDto) {
        UserEntity user = new UserEntity();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNo(userDto.getPhoneNo()); 
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        RoleEntity role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
    
    

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public List<User> findAllUsers() {
        	List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        	return users.stream()
        			.map((user)-> mapToUserDto(user))
        			.collect(Collectors.toList());
//        List<User> userDto = new ArrayList<User>();
//        for(UserEntity k :users)
//        {
//        	User user = mapToUserDto(k);
//        	userDto.add(user);
//        }

    }

    private User mapToUserDto(UserEntity user){
        User userDto = new User();
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private RoleEntity checkRoleExist(){
        RoleEntity role = new RoleEntity();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }


}