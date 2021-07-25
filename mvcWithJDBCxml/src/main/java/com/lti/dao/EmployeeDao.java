package com.lti.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.lti.model.*;;


@Repository
public class EmployeeDao {

	@Autowired
	@Qualifier("jtemplate1")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplatemydb;
	
	public List<Employee> getallEmp(){
		List<Map<String,Object>> listOfMap= namedParameterJdbcTemplatemydb.getJdbcOperations().queryForList("SELECT * FROM mydb.myemp");
		List<Employee> emp = new ArrayList<Employee>();
		for(Map<String,Object> map: listOfMap) {
			Employee e = new Employee();
			e.setEmpID((Integer) map.get("empid"));
			e.setEmpName((String) map.get("emp_name"));
			e.setEmpDesignation((String) map.get("emp_designation"));
			emp.add(e);
		}
		return emp;
		
	}
}
