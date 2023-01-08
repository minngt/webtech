package de.htwberlin.webtech.web.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class RecipeManipulationRequest {

    @Size(min = 3, message = "Please provide a recipe name with at least 3 letters")
    private String recipeName;
    @Pattern(
            regexp ="STARTER|MAIN_COURSE|DESSERT|DRINK|OTHER",
            message = "Please provide STARTER/ MAIN_COURSE/ DESSERT/ DRINK/ OTHER for category"
    )
    private String category;
    @NotBlank(message="The ingredients should not be empty")
    private String ingredients;
    @Positive(message = "Portion should be greater than 0")
    private int portion;
    @Positive(message = "Total time should be greater than 0")
    private int totalTime;
    @NotBlank(message="The instruction should not be empty")
    private String instruction;


    public RecipeManipulationRequest(String recipeName, String category, String ingredients, int portion, int totalTime, String instruction) {
        this.recipeName = recipeName;
        this.category = category;
        this.ingredients = ingredients;
        this.portion = portion;
        this.totalTime = totalTime;
        this.instruction = instruction;
    }

    public RecipeManipulationRequest(){}

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
