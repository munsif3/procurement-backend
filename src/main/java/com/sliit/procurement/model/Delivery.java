package com.sliit.procurement.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author munsif
 */
@Entity
@Table(name = "delivery",  schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d")
    , @NamedQuery(name = "Delivery.findByDeliveryNo", query = "SELECT d FROM Delivery d WHERE d.deliveryNo = :deliveryNo")
    , @NamedQuery(name = "Delivery.findByDeliveryId", query = "SELECT d FROM Delivery d WHERE d.deliveryId = :deliveryId")
    , @NamedQuery(name = "Delivery.findByDeliveredDate", query = "SELECT d FROM Delivery d WHERE d.deliveredDate = :deliveredDate")
    , @NamedQuery(name = "Delivery.findByLocation", query = "SELECT d FROM Delivery d WHERE d.location = :location")
    , @NamedQuery(name = "Delivery.findByComment", query = "SELECT d FROM Delivery d WHERE d.comment = :comment")})
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deliveryNo")
    private Integer deliveryNo;

    @Column(name = "deliveryId")
    private String deliveryId;

    @Column(name = "deliveredDate")
    @Temporal(TemporalType.DATE)
    private Date deliveredDate;

    @Column(name = "location")
    private String location;

    @Column(name = "comment")
    private String comment;

    @JoinColumn(name = "purchaseNo", referencedColumnName = "purchaseNo")
    @ManyToOne
    private PurchaseOrder purchaseNo;

    public Delivery() {
    }

    public Delivery(Integer deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public Integer getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(Integer deliveryNo) {
        this.deliveryNo = deliveryNo;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Date getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(Date deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public PurchaseOrder getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(PurchaseOrder purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliveryNo != null ? deliveryNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.deliveryNo == null && other.deliveryNo != null) || (this.deliveryNo != null && !this.deliveryNo.equals(other.deliveryNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mvndb.Delivery[ deliveryNo=" + deliveryNo + " ]";
    }
    
}
