package com.sliit.procurement.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="supplier")
public class Supplier extends User{

    //@Column(name="supplierId")
	private String supplierId;

    @Column(name="companyName")
	private String companyName;

    @Column(name="contractedDate")
	private Date contractedDate;

    @Column(name="deliveryChargePercent")
	private Double deliveryChargePercent;

    @Column(name="approximateDelivaryDays")
	private int approximateDelivaryDays;


    @OneToMany(mappedBy = "supplier")
	private Set<ItemSupplier> itemSuppliers;

    @OneToMany(mappedBy = "supplier")
    private List<PurchaseOrder> purchaseOrders;
	
	public Supplier(){
		
	}
	
	public Supplier(String companyName, Date contractedDate, Double deliveryChargePercent,
			int approximateDelivaryDays, Set<ItemSupplier> itemSuppliers) {
		super();
		this.companyName = companyName;
		this.contractedDate = contractedDate;
		this.deliveryChargePercent = deliveryChargePercent;
		this.approximateDelivaryDays = approximateDelivaryDays;
		this.itemSuppliers = itemSuppliers;
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


    public Set<ItemSupplier> getItemSuppliers() {
        return itemSuppliers;
    }

    public void setItemSuppliers(Set<ItemSupplier> itemSuppliers) {
        this.itemSuppliers = itemSuppliers;
    }
	
}
