package de.htwberlin.webtech.web.api;

public class ItemCreateRequest {

    private String itemName;
    private String unit;
    private double quantity;


    public ItemCreateRequest(String itemName, String unit, double quantity) {
        this.itemName = itemName;
        this.unit = unit;
        this.quantity = quantity;
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
