package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//here the Class Name is same as Table Name both are Contact
@Entity
public class Contact {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	@Column(name = "contact_id")
	private int cId;
	
	@Column(name = "name")
	private String cName;
	
	@Column(name = "email")
	private String email;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contact [cId=" + cId + ", cName=" + cName + ", email=" + email + ", getcId()=" + getcId()
				+ ", getcName()=" + getcName() + ", getEmail()=" + getEmail() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
