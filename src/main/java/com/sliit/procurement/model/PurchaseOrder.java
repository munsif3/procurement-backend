package com.sliit.procurement.model;

import com.fasterxml.jackson.annotation.*;
import com.sliit.procurement.model.Employee;
import com.sliit.procurement.model.Supplier;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author munsif
 */
@Entity
@Table(name = "purchase_order",  schema = "")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "PurchaseOrder.findAll", query = "SELECT p FROM PurchaseOrder p")
//    , @NamedQuery(name = "PurchaseOrder.findByPurchaseNo", query = "SELECT p FROM PurchaseOrder p WHERE p.purchaseNo = :purchaseNo")
//    , @NamedQuery(name = "PurchaseOrder.findByPurchaseId", query = "SELECT p FROM PurchaseOrder p WHERE p.purchaseId = :purchaseId")
//    , @NamedQuery(name = "PurchaseOrder.findByRequestedDate", query = "SELECT p FROM PurchaseOrder p WHERE p.requestedDate = :requestedDate")
//    , @NamedQuery(name = "PurchaseOrder.findByPreparedDate", query = "SELECT p FROM PurchaseOrder p WHERE p.preparedDate = :preparedDate")
//    , @NamedQuery(name = "PurchaseOrder.findByApprovedDate", query = "SELECT p FROM PurchaseOrder p WHERE p.approvedDate = :approvedDate")
//    , @NamedQuery(name = "PurchaseOrder.findByPurchaseExpectedDate", query = "SELECT p FROM PurchaseOrder p WHERE p.purchaseExpectedDate = :purchaseExpectedDate")
//    , @NamedQuery(name = "PurchaseOrder.findByTotalAmount", query = "SELECT p FROM PurchaseOrder p WHERE p.totalAmount = :totalAmount")
//    , @NamedQuery(name = "PurchaseOrder.findByStatus", query = "SELECT p FROM PurchaseOrder p WHERE p.status = :status")
//    , @NamedQuery(name = "PurchaseOrder.findByComments", query = "SELECT p FROM PurchaseOrder p WHERE p.comments = :comments")})
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "purchaseNo")
    private Integer purchaseNo;

    @Column(name = "purchaseId")
    private String purchaseId;

    @Column(name = "requestedDate")
    @Temporal(TemporalType.DATE)
    private Date requestedDate;

    @Column(name = "preparedDate")
    @Temporal(TemporalType.DATE)
    private Date preparedDate;

    @Column(name = "approvedDate")
    @Temporal(TemporalType.DATE)
    private Date approvedDate;

    @Column(name = "purchaseExpectedDate")
    @Temporal(TemporalType.DATE)
    private Date purchaseExpectedDate;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalAmount")
    private Float totalAmount;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrder")
    private List<PurchaseOrderItem> purchaseOrderItemList;


    @OneToMany(mappedBy = "purchaseNo")
    private List<Delivery> deliveryList;


    @JoinColumn(name = "approvedBy", referencedColumnName = "personNo")
    @ManyToOne
    @XmlTransient
    private Employee approvedBy;


    @JoinColumn(name = "preparedBy", referencedColumnName = "personNo")
    @ManyToOne
    @XmlTransient
    private Employee preparedBy;


    @JoinColumn(name = "requestedBy", referencedColumnName = "personNo")
    @ManyToOne
    @XmlTransient
    private Employee requestedBy;

    @JsonIgnore
    @JoinColumn(name = "supplierNo", referencedColumnName = "personNo")
    @ManyToOne
//    @JsonManagedReference
//    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "personNo")
    private Supplier supplierNo;


    @OneToMany(mappedBy = "purchaseNo")
    private List<Payment> paymentList;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Integer purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public Integer getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(Integer purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }
    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getPreparedDate() {
        return preparedDate;
    }

    public void setPreparedDate(Date preparedDate) {
        this.preparedDate = preparedDate;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Date getPurchaseExpectedDate() {
        return purchaseExpectedDate;
    }

    public void setPurchaseExpectedDate(Date purchaseExpectedDate) {
        this.purchaseExpectedDate = purchaseExpectedDate;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    //@XmlTransient
    public List<PurchaseOrderItem> getPurchaseOrderItemList() {
        return purchaseOrderItemList;
    }

    public void setPurchaseOrderItemList(List<PurchaseOrderItem> purchaseOrderItemList) {
        this.purchaseOrderItemList = purchaseOrderItemList;
    }

//    @XmlTransient
    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public void setDeliveryList(List<Delivery> deliveryList) {
        this.deliveryList = deliveryList;
    }
//
//    @XmlTransient
    public Employee getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Employee approvedBy) {
        this.approvedBy = approvedBy;
    }

//    @XmlTransient
    public Employee getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(Employee preparedBy) {
        this.preparedBy = preparedBy;
    }

//    @XmlTransient
    public Employee getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(Employee requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Supplier getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(Supplier supplierNo) {
        this.supplierNo = supplierNo;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseNo != null ? purchaseNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrder)) {
            return false;
        }
        PurchaseOrder other = (PurchaseOrder) object;
        if ((this.purchaseNo == null && other.purchaseNo != null) || (this.purchaseNo != null && !this.purchaseNo.equals(other.purchaseNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mvndb.PurchaseOrder[ purchaseNo=" + purchaseNo + " ]";
    }
    
}
