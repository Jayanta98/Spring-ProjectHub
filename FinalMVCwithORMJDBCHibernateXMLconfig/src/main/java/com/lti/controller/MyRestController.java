package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dao.ContactDao;
import com.lti.dao.EmployeeDao;
import com.lti.model.Contact;
import com.lti.model.Employee;

@RestController
public class MyRestController {
	
	@Autowired
	private ContactDao cDao;
	
	@Autowired
	private EmployeeDao eDao;
	

	@RequestMapping(method = RequestMethod.GET ,value = "/restCon")
	public List<Contact> getAllContactREST(){
		return cDao.getallContactREST();
	}
	
	@RequestMapping(method = RequestMethod.GET ,value = "/restemp")
	public List<Employee> getAllEMPREST(){
		return eDao.getallEMPREST();
	}

}
