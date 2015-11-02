package com.couponvault.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


/**
 * The persistent class for the coupons database table.
 * 
 */
@Entity
@Table(name="coupons")
@NamedQuery(name="Coupon.findAll", query="SELECT c FROM Coupon c")
public class Coupon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="coupon_code", unique=true, nullable=false, length=50)
	
	private String couponCode;

	@Temporal(TemporalType.DATE)
	@Column(name="coupon_add_date")
	
	private Date couponAddDate;

	
	@Column(name="coupon_pin", length=20)
	private String couponPin;

	
	@Column(name="coupon_used")
	private Boolean couponUsed;

	//bi-directional one-to-one association to CouponDescription
	@OneToOne(mappedBy="coupon")
	
	private CouponDescription couponDescription;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="username")
	
	private User user;

	public Coupon() {
	}
	@JsonProperty("CouponCode")
	public String getCouponCode() {
		return this.couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	@JsonProperty
	public Date getCouponAddDate() {
		return this.couponAddDate;
	}

	public void setCouponAddDate(Date couponAddDate) {
		this.couponAddDate = couponAddDate;
	}
	@JsonProperty
	public String getCouponPin() {
		return this.couponPin;
	}

	public void setCouponPin(String couponPin) {
		this.couponPin = couponPin;
	}
	@JsonProperty
	public Boolean getCouponUsed() {
		return this.couponUsed;
	}

	public void setCouponUsed(Boolean couponUsed) {
		this.couponUsed = couponUsed;
	}
	@JsonProperty
	public CouponDescription getCouponDescription() {
		return this.couponDescription;
	}

	public void setCouponDescription(CouponDescription couponDescription) {
		this.couponDescription = couponDescription;
	}
	@JsonIgnore
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}