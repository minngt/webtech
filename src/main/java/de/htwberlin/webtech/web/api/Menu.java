package de.htwberlin.webtech.web.api;

import java.util.List;

public class Menu {

    private long id;
    private String menuName;
    private String unit;
    private double quantity;
    private String category;
    private List<Long> extraName;

    public Menu(long id, String menuName, String unit, double quantity, String category, List<Long> extraName) {
        this.id = id;
        this.menuName = menuName;
        this.unit = unit;
        this.quantity = quantity;
        this.category = category;
        this.extraName = extraName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
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

    public List<Long> getExtraName() {
        return extraName;
    }

    public void setExtraName(List<Long> extraName) {
        this.extraName = extraName;
    }
}
