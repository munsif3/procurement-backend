package com.sliit.procurement.model;

import javax.persistence.*;

/**
 * Created by Munsif on 11/15/2017.
 */
@Entity
@Table(name = "site")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "siteId")
    private int siteId;

    @Column(name = "siteNo")
    private String siteNo;

    @Column(name = "siteName")
    private String siteName;

    @Column(name = "address")
    private String address;

    @OneToOne(mappedBy = "site")
    private Project project;

    @JoinColumn(name = "personNo")
    @OneToOne
    private Employee employee;

    public Site() {
    }

    public Site(String siteNo, String siteName, String address) {
        this.siteNo = siteNo;
        this.siteName = siteName;
        this.address = address;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getSiteNo() {
        return siteNo;
    }

    public void setSiteNo(String siteNo) {
        this.siteNo = siteNo;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
