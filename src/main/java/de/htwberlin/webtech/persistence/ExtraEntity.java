package de.htwberlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "extras")
public class ExtraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "extra_name", nullable = false)
    private String extraName;

    @Column(name = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "meal_id", referencedColumnName = "id")
    private MenuEntity meal;

    public ExtraEntity(){
    }

    public ExtraEntity(String extraName, Category category, MenuEntity meal) {
        this.extraName = extraName;
        this.category = category;
        this.meal = meal;
    }

    public Long getId() {
        return id;
    }

    public String getExtraName() {
        return extraName;
    }

    public void setExtraName(String extraName) {
        this.extraName = extraName;
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
