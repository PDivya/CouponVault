package com.couponvault.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false, length=45)
	
	private String username;
	
	@Column(nullable=false)
	private byte enabled;
	
	@Column(nullable=false, length=45)
	private String password;

	//bi-directional many-to-one association to Coupon
	
	@OneToMany(mappedBy="user")
	private List<Coupon> coupons;

	//bi-directional one-to-one association to UserDetail
	
	@Override
	public String toString() {
		return "User [username=" + username + ", enabled=" + enabled
				+ ", password=" + password + ", coupons=" + coupons
				+ ", userDetail=" + userDetail + ", userRoles=" + userRoles
				+ "]";
	}

	@OneToOne(mappedBy="user")
	private UserDetail userDetail;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	
	private List<UserRole> userRoles;

	public User() {
	}
	@JsonProperty
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@JsonProperty
	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}
	@JsonIgnore
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@JsonProperty
	public List<Coupon> getCoupons() {
		return this.coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	public Coupon addCoupon(Coupon coupon) {
		getCoupons().add(coupon);
		coupon.setUser(this);

		return coupon;
	}

	public Coupon removeCoupon(Coupon coupon) {
		getCoupons().remove(coupon);
		coupon.setUser(null);

		return coupon;
	}
	@JsonIgnore
	public UserDetail getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	@JsonProperty
	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

}