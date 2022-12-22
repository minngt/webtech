package de.htwberlin.webtech.web.api;

public class ExtraManipulationRequest {

    private String extraName;
    private String category;
    private Long mealId;

    public ExtraManipulationRequest(String extraName, String category, Long mealId) {
        this.extraName = extraName;
        this.category = category;
        this.mealId = mealId;
    }

    public ExtraManipulationRequest(){}

    public String getExtraName() {
        return extraName;
    }

    public void setExtraName(String extraName) {
        this.extraName = extraName;
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
