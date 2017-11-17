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
    @Column(name = "siteId")
    private String siteId;
    @Column(name = "address")
    private String address;


    public Site() {
    }

    public Site(String siteId, String address) {
        this.siteId = siteId;
        this.address = address;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
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
                " siteId= '" + siteId + '\'' +
                ", address= '" + address + '\'' +
                '}';
    }
}
