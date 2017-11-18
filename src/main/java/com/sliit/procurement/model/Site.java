package com.sliit.procurement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Munsif on 11/15/2017.
 */
@Entity
@Table(name = "site")
public class Site {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "siteNo")
	private int siteNo;

	@Column(name = "siteId")
	private String siteId;

	@Column(name = "siteName")
	private String siteName;

	@Column(name = "address")
	private String address;

	@OneToOne
	@JoinColumn(name = "siteManager")
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Site() {
	}

	public Site(String siteId, String siteName, String address) {
		this.siteId = siteId;
		this.address = address;
		this.siteName = siteName;
	}

	public int getSiteNo() {
		return siteNo;
	}

	public void setSiteNo(int siteNo) {
		this.siteNo = siteNo;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Site {" + " siteId= '" + siteId + '\'' + ", address= '" + address + '\'' + '}';
	}
}
