package com.stackroute.activitystream.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;




@Entity(name="User")
@Component
public class User extends ResourceSupport implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
	private String	emailId;
	private String	password;
	private String	name;
	private String address;
	private boolean active;
	private String phoneNo;
	
	public User()
	{
		
	}
	
	
	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public void setActive() {
		this.active = true;
	}
	
	
	public boolean isActive() {
		return  true;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	


	
}
