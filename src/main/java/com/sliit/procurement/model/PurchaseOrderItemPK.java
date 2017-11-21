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
public class PurchaseOrderItemPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "purchaseNo")
    private int purchaseNo;

    @Basic(optional = false)
    @Column(name = "itemNo")
    private int itemNo;

    public PurchaseOrderItemPK() {
    }

    public PurchaseOrderItemPK(int purchaseNo, int itemNo) {
        this.purchaseNo = purchaseNo;
        this.itemNo = itemNo;
    }

    public int getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(int purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) purchaseNo;
        hash += (int) itemNo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderItemPK)) {
            return false;
        }
        PurchaseOrderItemPK other = (PurchaseOrderItemPK) object;
        if (this.purchaseNo != other.purchaseNo) {
            return false;
        }
        if (this.itemNo != other.itemNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mvndb.PurchaseOrderItemPK[ purchaseNo=" + purchaseNo + ", itemNo=" + itemNo + " ]";
    }
    
}
