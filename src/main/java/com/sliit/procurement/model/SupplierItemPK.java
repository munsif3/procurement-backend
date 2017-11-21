package com.sliit.procurement.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author munsif
 */
@Embeddable
public class SupplierItemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "itemNo")
    private int itemNo;
    @Basic(optional = false)
    @Column(name = "supplierNo")
    private int supplierNo;

    public SupplierItemPK() {
    }

    public SupplierItemPK(int itemNo, int supplierNo) {
        this.itemNo = itemNo;
        this.supplierNo = supplierNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getSupplierNo() {
        return supplierNo;
    }

    public void setSupplierNo(int supplierNo) {
        this.supplierNo = supplierNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) itemNo;
        hash += (int) supplierNo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupplierItemPK)) {
            return false;
        }
        SupplierItemPK other = (SupplierItemPK) object;
        if (this.itemNo != other.itemNo) {
            return false;
        }
        if (this.supplierNo != other.supplierNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mvndb.SupplierItemPK[ itemNo=" + itemNo + ", supplierNo=" + supplierNo + " ]";
    }
    
}
