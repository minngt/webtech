package de.htwberlin.webtech.web.api;

public class Item {

    private long id;
    private String itemName;
    private String unit;
    private double quantity;

    public Item(long id, String itemName, String unit, double quantity) {
        this.id = id;
        this.itemName = itemName;
        this.unit = unit;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
