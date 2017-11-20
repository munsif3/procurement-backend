package com.sliit.procurement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="employee")
public class Employee extends User{

	
	
	@Column(name="employeeId")
	private String employeeId;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="Password")
	private String Password;
	
	@JoinColumn(name = "personNo")
    @OneToOne
    @MapsId
	private User user;
	
	@ManyToOne
    @JoinColumn(name = "department_id")
	
	private Department department;
	
	@ManyToOne
    @JoinColumn(name = "projectNo")
	
	private Project project;
	
	@OneToOne(mappedBy = "employee")
    private Site site;
	
	public Employee(){
		
	}
	
	/*public Employee(String employeeId, String designation, String userName, String password) {
		super();
		this.employeeId = employeeId;
		this.designation = designation;
		this.userName = userName;
		this.Password = password;
	}
*/

	

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
	
	
	
	
}
