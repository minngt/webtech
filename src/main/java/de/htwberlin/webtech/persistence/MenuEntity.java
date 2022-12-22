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

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "meal", fetch = FetchType.EAGER)
    private List<ExtraEntity> extras = new ArrayList<>();

    public MenuEntity(String menuName, String unit, Double quantity, Category category) {

        this.menuName = menuName;
        this.unit = unit;
        this.quantity = quantity;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ExtraEntity> getExtras() {
        return extras;
    }

    public void setExtras(List<ExtraEntity> extras) {
        this.extras = extras;
    }
}
