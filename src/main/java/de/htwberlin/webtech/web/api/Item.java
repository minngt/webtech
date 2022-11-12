package de.htwberlin.webtech.web.api;

public class Item {

    private long id;
    private String ingredientName;
    private String unit;
    private double quantity;

    public Item(long id, String ingredientName, String unit, double quantity) {
        this.id = id;
        this.ingredientName = ingredientName;
        this.unit = unit;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
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
