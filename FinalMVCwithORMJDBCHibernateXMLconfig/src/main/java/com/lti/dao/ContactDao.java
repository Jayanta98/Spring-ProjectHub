package com.lti.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lti.model.Contact;

@Repository
public class ContactDao {
	
	
	
	@Autowired
	@Qualifier("jtemplate2")
	private NamedParameterJdbcTemplate namedParameterjdbcTemplateFormyseconddb;
	
	public List<Contact> getallContact(){
		List<Map<String,Object>> listOfMap= namedParameterjdbcTemplateFormyseconddb.getJdbcOperations().queryForList("SELECT * FROM myseconddb.contact");
		List<Contact> con = new ArrayList<Contact>();
		for(Map<String,Object> map: listOfMap) {
			Contact e = new Contact();
			e.setcId((Integer) map.get("contact_id"));
			e.setcName((String) map.get("name"));
			e.setEmail((String) map.get("email"));
			con.add(e);
		}
		return con;
		
	}
		@Autowired
	    @Qualifier("myEmfFormySecondDB")
	    EntityManagerFactory em;
	
	
	
	public List<Contact> getallContactREST(){
	  EntityManager em1= em.createEntityManager();
		
		return em1.createQuery("select a from Contact a").getResultList();
	}
	
}



