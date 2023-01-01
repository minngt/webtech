package de.htwberlin.webtech.web.api;

public class Ingredient {
    private Long id;
    private String ingsName;
    private double quantity;
    private String unit;
    private String category;
    private Menu menu;

    public Ingredient(Long id, String ingsName, double quantity, String unit, String category, Menu menu) {
        this.id = id;
        this.ingsName = ingsName;
        this.quantity = quantity;
        this.unit = unit;
        this.category = category;
        this.menu = menu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIngsName() {
        return ingsName;
    }

    public void setIngsName(String ingsName) {
        this.ingsName = ingsName;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Menu getMenu() { return menu; }

    public void setMenu(Menu menu) { this.menu = menu; }
}
