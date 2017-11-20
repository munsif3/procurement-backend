package com.sliit.procurement.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table(name="supplier")
public class Supplier extends User{

	@Column(name="supplierId")
	private String supplierId;
	@Column(name="companyName")
	private String companyName;
	@Column(name="contractedDate")
	private Date contractedDate;
	@Column(name="deliveryChargePercent")
	private Double deliveryChargePercent;
	@Column(name="approximateDelivaryDays")
	private int approximateDelivaryDays;
	
	public Supplier(){
		
	}
	
	public Supplier(String companyName, Date contractedDate, Double deliveryChargePercent,
			int approximateDelivaryDays) {
		super();
		this.companyName = companyName;
		this.contractedDate = contractedDate;
		this.deliveryChargePercent = deliveryChargePercent;
		this.approximateDelivaryDays = approximateDelivaryDays;
	}


	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getContractedDate() {
		return contractedDate;
	}
	public void setContractedDate(Date contractedDate) {
		this.contractedDate = contractedDate;
	}
	public Double getDeliveryChargePercent() {
		return deliveryChargePercent;
	}
	public void setDeliveryChargePercent(Double deliveryChargePercent) {
		this.deliveryChargePercent = deliveryChargePercent;
	}
	public int getApproximateDelivaryDays() {
		return approximateDelivaryDays;
	}
	public void setApproximateDelivaryDays(int approximateDelivaryDays) {
		this.approximateDelivaryDays = approximateDelivaryDays;
	}
	
	
}
