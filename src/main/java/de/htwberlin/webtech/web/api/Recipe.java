package de.htwberlin.webtech.web.api;

public class Recipe {

    private long id;
    private String recipeName;
    private String category;
    private String ingredients;
    private int portion;
    private int totalTime;
    private String direction;


    public Recipe(long id, String recipeName, String category, String ingredients, int portion, int totalTime, String direction) {
        this.id = id;
        this.recipeName = recipeName;
        this.category = category;
        this.ingredients = ingredients;
        this.portion = portion;
        this.totalTime = totalTime;
        this.direction = direction;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
