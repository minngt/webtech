package de.htwberlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "unit")
    private String unit;

    @Column(name ="quantity")
    private Double quantity;

    public ItemEntity(String itemName, String unit, Double quantity) {

        this.itemName = itemName;
        this.unit = unit;
        this.quantity = quantity;
    }

    protected ItemEntity() {}

    public Long getId() {
        return id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
