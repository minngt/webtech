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

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "meal", fetch = FetchType.EAGER)
    private List<IngredientEntity> ingredients = new ArrayList<>();

    public MenuEntity(String menuName, Category category) {
        this.menuName = menuName;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }
}
