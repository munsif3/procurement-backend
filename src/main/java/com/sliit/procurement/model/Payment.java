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
@Table(name = "payment",  schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
    , @NamedQuery(name = "Payment.findByPaymentNo", query = "SELECT p FROM Payment p WHERE p.paymentNo = :paymentNo")
    , @NamedQuery(name = "Payment.findByPaymentId", query = "SELECT p FROM Payment p WHERE p.paymentId = :paymentId")
    , @NamedQuery(name = "Payment.findByPaymentDate", query = "SELECT p FROM Payment p WHERE p.paymentDate = :paymentDate")
    , @NamedQuery(name = "Payment.findByComment", query = "SELECT p FROM Payment p WHERE p.comment = :comment")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paymentNo")
    private Integer paymentNo;

    @Column(name = "paymentId")
    private String paymentId;

    @Column(name = "paymentDate")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(name = "comment")
    private String comment;

    @JoinColumn(name = "purchaseNo", referencedColumnName = "purchaseNo")
    @ManyToOne
    private PurchaseOrder purchaseNo;

    public Payment() {
    }

    public Payment(Integer paymentNo) {
        this.paymentNo = paymentNo;
    }

    public Integer getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(Integer paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
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
        hash += (paymentNo != null ? paymentNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentNo == null && other.paymentNo != null) || (this.paymentNo != null && !this.paymentNo.equals(other.paymentNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mvndb.Payment[ paymentNo=" + paymentNo + " ]";
    }

}
