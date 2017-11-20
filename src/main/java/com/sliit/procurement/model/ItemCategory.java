package com.sliit.procurement.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Munsif on 11/20/2017.
 */
@Entity
public class ItemCatalogue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemNo")
    private int itemNo;

    @Column(name = "itemId")
    private String itemId;

    @Column(name = "itemName")
    private String itemName;

    @Column(name = "itemDescription")
    private String itemDescription;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "item_catalogue_supplier", joinColumns = @JoinColumn(name = "itemNo", referencedColumnName = "itemNo"),
            inverseJoinColumns = @JoinColumn(name = "supplierId", referencedColumnName = "supplierId"))
    private List<Supplier> suppliers;

    public ItemCatalogue() {
    }

    public ItemCatalogue(String itemId, String itemName, String itemDescription) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}
