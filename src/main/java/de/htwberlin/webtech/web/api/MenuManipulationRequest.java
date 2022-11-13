package de.htwberlin.webtech.web.api;

public class MenuManipulationRequest {

    private String menuName;
    private String unit;
    private double quantity;
    private String course;


    public MenuManipulationRequest(String menuName, String unit, double quantity, String course) {
        this.menuName = menuName;
        this.unit = unit;
        this.quantity = quantity;
        this.course = course;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}