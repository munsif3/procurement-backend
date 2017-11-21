package com.sliit.procurement.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Munsif on 11/20/2017.
 */
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemNo")
    private int itemNo;

    @ManyToOne
    @JoinColumn(name = "itemCategory")
    private ItemCategory itemCategory;

    @Column(name = "itemId")
    private String itemId;

    @Column(name = "measurementUnit")
    private String measurementUnit;

    @Column(name = "unitPrice")
    private double unitPrice;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemSupplier> itemSuppliers;

    public Item() {
    }

    public Item(ItemCategory itemCategory, String itemId, String measurementUnit, double unitPrice, Set<ItemSupplier> itemSuppliers) {
        this.itemCategory = itemCategory;
        this.itemId = itemId;
        this.measurementUnit = measurementUnit;
        this.unitPrice = unitPrice;
        this.itemSuppliers = itemSuppliers;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Set<ItemSupplier> getItemSuppliers() {
        return itemSuppliers;
    }

    public void setItemSuppliers(Set<ItemSupplier> itemSuppliers) {
        this.itemSuppliers = itemSuppliers;
    }
}
