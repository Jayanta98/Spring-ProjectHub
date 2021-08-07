package com.mightyjava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView modelAndView = new ModelAndView("welcome");
		return modelAndView;
	}

}
