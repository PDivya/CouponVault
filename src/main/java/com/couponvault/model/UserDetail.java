package com.couponvault.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


/**
 * The persistent class for the user_details database table.
 * 
 */
@Entity
@Table(name="user_details")
@NamedQuery(name="UserDetail.findAll", query="SELECT u FROM UserDetail u")
@NamedNativeQuery(name="UserDetail.findAllNative",query= "select * from user_details",resultClass=UserDetail.class)
public class UserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	@Column(unique=true, nullable=false, length=45)
	private String username;
	
	@Column(length=50)
	private String city;
	
	@Column(length=50)
	private String country;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(length=200)
	private String email;
	
	@Column(name="first_name", nullable=false, length=120)
	private String firstName;
	
	@Column(name="last_name", nullable=false, length=60)
	private String lastName;
	
	@Column(name="middle_name", length=50)
	private String middleName;
	
	@Column(length=50)
	private String state;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="username", nullable=false, insertable=false, updatable=false)
	private User user;

	public UserDetail() {
	}
	@JsonProperty
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@JsonProperty
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@JsonProperty
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@JsonProperty
	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	@JsonProperty
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@JsonProperty
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@JsonProperty
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@JsonProperty
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	@JsonProperty
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@JsonIgnore
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}