package de.htwberlin.webtech.web.api;

public class IngredientManipulationRequest {

    private String ingsName;
    private double quantity;
    private String unit;
    private String category;
    private Long mealId;

    public IngredientManipulationRequest(String ingsName, double quantity, String unit,  String category, Long mealId) {
        this.ingsName = ingsName;
        this.quantity = quantity;
        this.unit = unit;
        this.category = category;
        this.mealId = mealId;
    }

    public IngredientManipulationRequest(){}

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

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }
}
