package com.catalyst.funds.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.catalyst.funds.User;
import com.catalyst.funds.entity.UserEntity;
import com.catalyst.funds.repositry.UserRepositry;
import com.catalyst.funds.repositry.UserService;



@Controller



public class WebController {

	@Autowired
	private UserRepositry userVar;
	@Autowired
	private UserService userservice;

	
	@GetMapping("/index")
	public String Homepage()
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model)
	{
		User userdto = new User();
		model.addAttribute("user",userdto);
		return "register";
		
	}
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") User userDto,
                               BindingResult result,
                               Model model){
        UserEntity existingUser = userservice.findUserByUsername(userDto.getUserName());

        if(existingUser != null && existingUser.getUserName() != null && !existingUser.getUserName().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userservice.saveUser(userDto);
        return "redirect:/register?success";
    }

		// handler method to handle list of users
		@GetMapping("/users")
		public String users(Model model){
		    List<User> users = userservice.findAllUsers();
		    model.addAttribute("users", users);
		    return "users";
		}
	    @GetMapping("/login")
	    public String login(){
	        return "login";
	    }
	    
}

	
//	@GetMapping("/register")
//	public String showRegistrationForm(Model model) {
//    model.addAttribute("userEntity", new UserEntity());
//     
//    return "signup_form.html";
//	}
//	
//	@PostMapping("/process_register")
//	public String processRegister(UserEntity user) {
//	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	    String encodedPassword = passwordEncoder.encode(user.getPassword());
//	    user.setPassword(encodedPassword);
//	     
//	    userVar.save(user);
//	     
//	    return "register_success.html";
//	}
//	@RequestMapping("/")
//	public String index(){
//		return "webpage.html";
//}
//	@RequestMapping("/login")
//	public String login() {
//		return "login.html";
//	}
//	

