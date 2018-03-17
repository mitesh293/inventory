package com.mit.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mit.model.User;
import com.mit.serviceImpl.LoginService;



@Controller
public class LoginController {
	
	private static final Logger logger = Logger
            .getLogger(LoginController.class);
	
	public LoginController() {
		System.out.println("LoginController Initiallized...");
	}
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
		} else {
			return "redirect:/list";
		}
	}

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = loginService.findAllUsers();
		
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "userslist";
	}

	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof User) {
			userName = ((User) principal).getUserName();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
