package de.htwberlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "ingredients")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ings_name", nullable = false)
    private String ingsName;

    @Column(name ="quantity")
    private Double quantity;

    @Column(name = "unit")
    private String unit;

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "meal_id", referencedColumnName = "id")
    private MenuEntity meal;

    public IngredientEntity(){
    }

    public IngredientEntity(String ingsName, Double quantity, String unit, Category category, MenuEntity meal) {
        this.ingsName = ingsName;
        this.quantity = quantity;
        this.unit = unit;
        this.category = category;
        this.meal = meal;
    }

    public Long getId() {
        return id;
    }

    public String getIngsName() {
        return ingsName;
    }

    public void setIngsName(String ingsName) {
        this.ingsName =ingsName;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MenuEntity getMeal() {
        return meal;
    }

    public void setMeal(MenuEntity meal) {
        this.meal = meal;
    }
}
