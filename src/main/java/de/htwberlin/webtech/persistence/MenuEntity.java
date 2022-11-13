package de.htwberlin.webtech.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "menus")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "menu_name", nullable = false)
    private String menuName;

    @Column(name = "unit")
    private String unit;

    @Column(name ="quantity")
    private Double quantity;

    @Column(name = "course")
    @Enumerated(value = EnumType.STRING)
    private Course course;

    @OneToMany(mappedBy = "meal", fetch = FetchType.EAGER)
    private List<IngredientEntity> ingredients = new ArrayList<>();

    public MenuEntity(String menuName, String unit, Double quantity, Course course) {

        this.menuName = menuName;
        this.unit = unit;
        this.quantity = quantity;
        this.course = course;
    }

    protected MenuEntity() {}

    public Long getId() {
        return id;
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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }
}
