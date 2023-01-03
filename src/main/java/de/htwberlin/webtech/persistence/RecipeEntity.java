package de.htwberlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "recipes")
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "recipe_name", nullable = false)
    private String recipeName;

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(name = "ingredients", nullable = false)
    private String ingredients;

    @Column(name = "portion")
    private int portion;
    @Column(name = "total_time")
    private int totalTime;
    @Column(name = "direction")
    private String direction;


    public RecipeEntity(String recipeName, Category category, String ingredients, int portion, int totalTime, String direction) {
        this.recipeName = recipeName;
        this.category = category;
        this.ingredients = ingredients;
        this.portion = portion;
        this.totalTime = totalTime;
        this.direction = direction;

    }

    protected RecipeEntity() {}

    public Long getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
