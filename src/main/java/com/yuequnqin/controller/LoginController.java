package com.yuequnqin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yuequnqin.domain.User;
import com.yuequnqin.service.UserService;

@Controller
public class LoginController {


	@Autowired
	@Qualifier(value="userService")
	private UserService userService;
	
	@RequestMapping("/login/login")
	public String login(User user,Model model){
		System.out.println("username"+user.getUsername());
		boolean isExist=userService.isUserExist(user);
		model.addAttribute("username", user.getUsername());
		if(isExist)
		    return "loginSuccess";
		else
			return "login";
	}
	
	@RequestMapping("/login/hello")
	public ModelAndView hello(){
		return new ModelAndView("login");
	}
	
}
