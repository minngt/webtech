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

    @Column(name = "course")
    @Enumerated(value = EnumType.STRING)
    private Course course;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "meal_id", referencedColumnName = "id")
    private MenuEntity meal;

    public  IngredientEntity(){

    }

    public IngredientEntity(String ingsName, Course course, MenuEntity meal) {
        this.ingsName = ingsName;
        this.course = course;
        this.meal = meal;
    }

    public Long getId() {
        return id;
    }

    public String getIngsName() {
        return ingsName;
    }

    public void setIngsName(String ingsName) {
        this.ingsName = ingsName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public MenuEntity getMeal() {
        return meal;
    }

    public void setMeal(MenuEntity meal) {
        this.meal = meal;
    }
}
