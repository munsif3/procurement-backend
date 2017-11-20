package com.sliit.procurement.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "department")
public class Department implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "departmentNo")
	private int departmentNo;

	@Column(name = "departmentId", unique = true)
	private String departmentId;

	@Column(name = "departmentName", unique = true)
	private String departmentName;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Employee> employees;

	public Department() {

	}

	public Department(String departmentName) {
		super();
	
		this.departmentName = departmentName;
	}

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
