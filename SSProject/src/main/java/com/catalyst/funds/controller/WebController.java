package com.catalyst.funds.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
@EnableWebMvc
public class WebController extends WebMvcConfigurerAdapter {
	

    
	@RequestMapping("/")
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



	}
	

