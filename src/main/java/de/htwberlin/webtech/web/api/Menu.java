package de.htwberlin.webtech.web.api;

import java.util.List;

public class Menu {

    private long id;
    private String menuName;
    private String category;
    private List<String> ingsName;

    public Menu(long id, String menuName, String category, List<String> ingsName) {
        this.id = id;
        this.menuName = menuName;
        this.category = category;
        this.ingsName = ingsName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getIngsName() {
        return ingsName;
    }

    public void setIngsName(List<String> ingsName) {
        this.ingsName = ingsName;
    }
}
