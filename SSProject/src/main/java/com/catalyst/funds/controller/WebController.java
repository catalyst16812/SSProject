package com.catalyst.funds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class WebController {
	
	@RequestMapping("/")
	public String index(){
		return "webpage.html";
	}
	@RequestMapping("/adduser")
	public String adduser() {
		return "login.html";
	}
}
