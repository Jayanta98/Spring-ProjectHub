package com.lti.session.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "account")
public class AccountController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "account/index";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		HttpSession session,
		ModelMap modelMap) {
		if(username.equalsIgnoreCase("acc1") && password.equalsIgnoreCase("123")) {
			session.setAttribute("username", username);
			return "account/success";
		} else {
			modelMap.put("error", "Invalid Account");
			return "account/index";
		}
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:../account";
	}
	
	@RequestMapping(value = "data", method = RequestMethod.GET)
	public String data(HttpSession session) {
		String name =(String) session.getAttribute("username");
		if(name!=null) {
			return "data/data";
		}else {
			return "redirect:../account";
		}
		
		
	}

}
