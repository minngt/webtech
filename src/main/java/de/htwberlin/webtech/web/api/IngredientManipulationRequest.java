package de.htwberlin.webtech.web.api;

public class IngredientManipulationRequest {

    private String ingsName;
    private String course;
    private Long mealId;

    public IngredientManipulationRequest(String ingsName, String course, Long mealId) {
        this.ingsName = ingsName;
        this.course = course;
        this.mealId = mealId;
    }

    public IngredientManipulationRequest(){}

    public String getIngsName() {
        return ingsName;
    }

    public void setIngsName(String ingsName) {
        this.ingsName = ingsName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }
}
