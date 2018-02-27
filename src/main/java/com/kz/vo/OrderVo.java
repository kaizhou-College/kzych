package com.kz.vo;

import java.math.BigDecimal;
import java.util.List;

import com.kz.po.Major;

public class OrderVo {
	/*学校编号*/
	private Long universtityId;
	/*专业编号*/
	private Long majorId;
	/*学费*/
	private BigDecimal cost;
	/*支付方式*/
	private int paymentType;
	/*代金券*/
	private BigDecimal coupon;
	/*助学金*/
	private BigDecimal grants;
	/*实际支付金额*/
	private BigDecimal payment;
	
	public Long getUniverstityId() {
		return universtityId;
	}
	public void setUniverstityId(Long universtityId) {
		this.universtityId = universtityId;
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
	public int getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
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
	public BigDecimal getPayment() {
		return payment;
	}
	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "OrderVo [universtityId=" + universtityId + ", majorId=" + majorId + ", cost=" + cost + ", paymentType="
				+ paymentType + ", coupon=" + coupon + ", grants=" + grants + ", payment=" + payment + "]";
	}
	
	
}
