package com.couponvault.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the coupon_description database table.
 * 
 */
@Entity
@Table(name="coupon_description")
@NamedQuery(name="CouponDescription.findAll", query="SELECT c FROM CouponDescription c")
public class CouponDescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="coupon_code_parent", unique=true, nullable=false, length=50)
	private String couponCodeParent;

	@Temporal(TemporalType.DATE)
	@Column(name="coupon_valid_from")
	private Date couponValidFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="coupon_valid_to")
	private Date couponValidTo;

	private Boolean isprivate;

	private Boolean istradeable;

	private Boolean isvisible;

	//bi-directional one-to-one association to Coupon
	@OneToOne
	@JoinColumn(name="coupon_code_parent", nullable=false, insertable=false, updatable=false)
	private Coupon coupon;

	public CouponDescription() {
	}

	public String getCouponCodeParent() {
		return this.couponCodeParent;
	}

	public void setCouponCodeParent(String couponCodeParent) {
		this.couponCodeParent = couponCodeParent;
	}

	public Date getCouponValidFrom() {
		return this.couponValidFrom;
	}

	public void setCouponValidFrom(Date couponValidFrom) {
		this.couponValidFrom = couponValidFrom;
	}

	public Date getCouponValidTo() {
		return this.couponValidTo;
	}

	public void setCouponValidTo(Date couponValidTo) {
		this.couponValidTo = couponValidTo;
	}

	public Object getIsprivate() {
		return this.isprivate;
	}

	public void setIsprivate(Boolean isprivate) {
		this.isprivate = isprivate;
	}

	public Boolean getIstradeable() {
		return this.istradeable;
	}

	public void setIstradeable(Boolean istradeable) {
		this.istradeable = istradeable;
	}

	public Object getIsvisible() {
		return this.isvisible;
	}

	public void setIsvisible(Boolean isvisible) {
		this.isvisible = isvisible;
	}

	public Coupon getCoupon() {
		return this.coupon;
	}

	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}

}