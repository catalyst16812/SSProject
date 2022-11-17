package com.catalyst.funds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.catalyst.funds.entity.UserEntity;
import com.catalyst.funds.repositry.UserAuthRepositry;
import com.catalyst.funds.repositry.UserRepositry;


@Controller
@EnableWebMvc
public class WebController extends WebMvcConfigurerAdapter {
	
    @Autowired
    private UserRepositry userRepo;
    
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        
        return "signup_form";
    }
    
    @PostMapping("/process_register")
    public String processRegister(UserEntity user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        
        userRepo.save(user);
        
        return "register_success";
    }
    
    @GetMapping("/users")
    public String listUsers(Model model) {
        Iterable<UserEntity> listUsers = userRepo.findAll();
        model.addAttribute("listUsers", listUsers);
        
        return "users";
    }
    
	@RequestMapping("/userhome")
	public String index(){
		return "webpage.html";
}
	@RequestMapping("/login")
	public String login() {
		return "login.html";
	}
	@RequestMapping("/loginerror")
	public String loignerror() {
		return "loginerror.html";
	}
	@RequestMapping("/signup")
	public String signup() {
		return "signup.html";
	}
	@RequestMapping("/createteam")
	public String addteam() {
	    return "teamadd.html";
	}
	@RequestMapping("/addtoteam")
	public String addtoteam() {
	    return "addtoteam.html";
	}
    @RequestMapping("/admin")
    public String admin() {
        return "admin.html";
    }
    @RequestMapping("/modifyteam")
    public String modifyteam() {
        return "modifyteam.html";
    }
    @RequestMapping("/about")
    public String about() {
        return "about.html";
    }
	}
	

