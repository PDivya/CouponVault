package com.couponvault.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The persistent class for the user_roles database table.
 * 
 */
@Entity
@Table(name="user_roles")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_role_id", unique=true, nullable=false)
	private int userRoleId;

	@Column(nullable=false, length=45)
	private String role;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username", nullable=false)
	private User user;

	public UserRole() {
	}
	@JsonProperty
	public int getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	@JsonProperty
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@JsonIgnore
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}