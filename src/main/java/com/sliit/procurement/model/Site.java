package com.sliit.procurement.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Munsif on 11/15/2017.
 */
@Entity
@Table(name = "site")
public class Site {

    @Id
    @Column(name = "siteNo")
    private String siteNo;
    @Column(name = "address")
    private String address;


    public Site() {
    }

    public Site(String siteNo, String address) {
        this.siteNo = siteNo;
        this.address = address;
    }

    public String getSiteNo() {
        return siteNo;
    }

    public void setSiteNo(String siteNo) {
        this.siteNo = siteNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Site {" +
                " siteNo= '" + siteNo + '\'' +
                ", address= '" + address + '\'' +
                '}';
    }
}
