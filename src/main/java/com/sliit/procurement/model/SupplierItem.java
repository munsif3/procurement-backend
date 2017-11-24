package com.sliit.procurement.model;

import com.sliit.procurement.model.Supplier;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author munsif
 */
@Entity
@Table(name = "supplier_item",  schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SupplierItem.findAll", query = "SELECT s FROM SupplierItem s")
    , @NamedQuery(name = "SupplierItem.findByItemNo", query = "SELECT s FROM SupplierItem s WHERE s.supplierItemPK.itemNo = :itemNo")
    , @NamedQuery(name = "SupplierItem.findBySupplierNo", query = "SELECT s FROM SupplierItem s WHERE s.supplierItemPK.supplierNo = :supplierNo")
    , @NamedQuery(name = "SupplierItem.findByUnitPrice", query = "SELECT s FROM SupplierItem s WHERE s.unitPrice = :unitPrice")})
public class SupplierItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SupplierItemPK supplierItemPK;

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "unitPrice")
    private Float unitPrice;

    @JoinColumn(name = "itemNo", referencedColumnName = "itemNo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    @JoinColumn(name = "supplierNo", referencedColumnName = "personNo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Supplier supplier;

    public SupplierItem() {
    }

    public SupplierItem(SupplierItemPK supplierItemPK) {
        this.supplierItemPK = supplierItemPK;
    }

    public SupplierItem(int itemNo, int supplierNo) {
        this.supplierItemPK = new SupplierItemPK(itemNo, supplierNo);
    }

    public SupplierItemPK getSupplierItemPK() {
        return supplierItemPK;
    }

    public void setSupplierItemPK(SupplierItemPK supplierItemPK) {
        this.supplierItemPK = supplierItemPK;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (supplierItemPK != null ? supplierItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplierItem)) {
            return false;
        }
        SupplierItem other = (SupplierItem) object;
        if ((this.supplierItemPK == null && other.supplierItemPK != null) || (this.supplierItemPK != null && !this.supplierItemPK.equals(other.supplierItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mvndb.SupplierItemService[ supplierItemPK=" + supplierItemPK + " ]";
    }
    
}
