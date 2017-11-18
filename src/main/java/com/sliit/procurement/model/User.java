package com.sliit.procurement.model;

public class Person {
	public static void main(String [] args){
		System.out.print("");
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="personNo")
	private int personNo;
	@Column(name = "personId", unique = true)
	private String personId;
	@Column(name = "name", unique = true)
	private String name;
	@Column(name = "NIC", unique = true)
	private String nic;
	@Column(name = "contactNo", unique = true)
	private int contactNo;
	@Column(name = "email", unique = true)
	private String email;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Employee employee;
	public User(){
	}
	
	public User(String name, String nic, int contactNo, String email) {
		super();
		this.name = name;
		this.nic = nic;
		this.contactNo = contactNo;
		this.email = email;
	}

	public int getPersonNo() {
		return personNo;
	}
	public void setPersonNo(int personNo) {
		this.personNo = personNo;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
