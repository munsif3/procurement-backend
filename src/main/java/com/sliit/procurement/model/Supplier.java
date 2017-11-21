package com.sliit.procurement.model;

import com.sliit.procurement.model.PurchaseOrder;
import com.sliit.procurement.model.SupplierItem;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author munsif
 */
@Entity
@Table(name = "supplier",  schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s")
    , @NamedQuery(name = "Supplier.findByApproximateDelivaryDays", query = "SELECT s FROM Supplier s WHERE s.approximateDelivaryDays = :approximateDelivaryDays")
    , @NamedQuery(name = "Supplier.findByCompanyName", query = "SELECT s FROM Supplier s WHERE s.companyName = :companyName")
    , @NamedQuery(name = "Supplier.findByContractedDate", query = "SELECT s FROM Supplier s WHERE s.contractedDate = :contractedDate")
    , @NamedQuery(name = "Supplier.findByDeliveryChargePercent", query = "SELECT s FROM Supplier s WHERE s.deliveryChargePercent = :deliveryChargePercent")
    , @NamedQuery(name = "Supplier.findBySupplierId", query = "SELECT s FROM Supplier s WHERE s.supplierId = :supplierId")
    , @NamedQuery(name = "Supplier.findByPersonNo", query = "SELECT s FROM Supplier s WHERE s.personNo = :personNo")})
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "approximateDelivaryDays")
    private Integer approximateDelivaryDays;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "contractedDate")
    @Temporal(TemporalType.DATE)
    private Date contractedDate;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "deliveryChargePercent")
    private Float deliveryChargePercent;

    @Column(name = "supplierId")
    private String supplierId;

    @Id
    @Basic(optional = false)
    @Column(name = "personNo")
    private Integer personNo;

    @OneToMany(mappedBy = "supplierNo")
    private List<PurchaseOrder> purchaseOrderList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private List<SupplierItem> supplierItemList;

    @JoinColumn(name = "personNo", referencedColumnName = "personNo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Supplier() {
    }

    public Supplier(Integer personNo) {
        this.personNo = personNo;
    }

    public Integer getApproximateDelivaryDays() {
        return approximateDelivaryDays;
    }

    public void setApproximateDelivaryDays(Integer approximateDelivaryDays) {
        this.approximateDelivaryDays = approximateDelivaryDays;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getContractedDate() {
        return contractedDate;
    }

    public void setContractedDate(Date contractedDate) {
        this.contractedDate = contractedDate;
    }

    public Float getDeliveryChargePercent() {
        return deliveryChargePercent;
    }

    public void setDeliveryChargePercent(Float deliveryChargePercent) {
        this.deliveryChargePercent = deliveryChargePercent;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getPersonNo() {
        return personNo;
    }

    public void setPersonNo(Integer personNo) {
        this.personNo = personNo;
    }

    @XmlTransient
    public List<PurchaseOrder> getPurchaseOrderList() {
        return purchaseOrderList;
    }

    public void setPurchaseOrderList(List<PurchaseOrder> purchaseOrderList) {
        this.purchaseOrderList = purchaseOrderList;
    }

    @XmlTransient
    public List<SupplierItem> getSupplierItemList() {
        return supplierItemList;
    }

    public void setSupplierItemList(List<SupplierItem> supplierItemList) {
        this.supplierItemList = supplierItemList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personNo != null ? personNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.personNo == null && other.personNo != null) || (this.personNo != null && !this.personNo.equals(other.personNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mvndb.Supplier[ personNo=" + personNo + " ]";
    }
    
}
