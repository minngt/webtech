package de.htwberlin.webtech.web.api;

public class Ingredient {
    private Long id;
    private String ingsName;
    private String course;
    private Menu menu;

    public Ingredient(Long id, String ingsName, String course, Menu menu) {
        this.id = id;
        this.ingsName = ingsName;
        this.course = course;
        this.menu = menu;

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

    public Menu getMenu() { return menu; }

    public void setMenu(Menu menu) { this.menu = menu; }
}
