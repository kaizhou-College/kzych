package com.kz.po;

import java.math.BigDecimal;

public class OrderDetail {
	private Long id;

	private Long orderid;

	private Long universityId;

	private Long majorId;

	private BigDecimal cost;

	private BigDecimal coupon;

	private BigDecimal grants;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Long getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Long universityId) {
		this.universityId = universityId;
	}

	public Long getMajorId() {
		return majorId;
	}

	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public BigDecimal getCoupon() {
		return coupon;
	}

	public void setCoupon(BigDecimal coupon) {
		this.coupon = coupon;
	}

	public BigDecimal getGrants() {
		return grants;
	}

	public void setGrants(BigDecimal grants) {
		this.grants = grants;
	}
}