package de.htwberlin.webtech.web.api;

public class Ingredient {
    private Long id;
    private String ingsName;
    private String course;
    private Long menu_id;

    public Ingredient(Long id, String ingsName, String course, Long menu_id) {
        this.id = id;
        this.ingsName = ingsName;
        this.course = course;
        this.menu_id = menu_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Long menu_id) {
        this.menu_id = menu_id;
    }
}
