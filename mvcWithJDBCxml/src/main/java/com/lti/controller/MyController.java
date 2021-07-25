package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lti.dao.ContactDao;
import com.lti.dao.EmployeeDao;
import com.lti.model.Contact;
import com.lti.model.Employee;

@Controller
public class MyController {

	
	@Autowired
	private EmployeeDao eDao;
	
	@Autowired
	private ContactDao cDao;
	

	
	
	@RequestMapping(method = RequestMethod.GET ,value = "/allcon")
	public String getAllContact(){
		List<Contact> emp =cDao.getallContact();
		ModelAndView m = new ModelAndView();
		m.addObject(emp.toString());
		System.out.println("====================");
		System.out.println("Contact->"+emp.toString());
		return "contact";
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET ,value = "/allemp")
	public String getAllEmp(){
		List<Employee> emp =eDao.getallEmp();
		ModelAndView m = new ModelAndView();
		m.addObject(emp.toString());
		System.out.println("====================");
		System.out.println("My->"+emp.toString());
		return "my";
	}
}
