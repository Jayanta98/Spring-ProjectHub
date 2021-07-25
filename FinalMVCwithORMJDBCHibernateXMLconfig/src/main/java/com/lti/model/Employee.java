package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//here table name was not same with Class name so @Table(name = "myemp") needed
// you can set the less number of column in your class but cant max
@Entity
@Table(name = "myemp")
public class Employee {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name = "empid")
	private int empID;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "emp_designation")
	private String empDesignation;
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", empName=" + empName + ", empDesignation=" + empDesignation
				+ ", getEmpID()=" + getEmpID() + ", getEmpName()=" + getEmpName() + ", getEmpDesignation()="
				+ getEmpDesignation() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

}
