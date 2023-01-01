package de.htwberlin.webtech.web.api;

public class MenuManipulationRequest {

    private String menuName;
    private String category;


    public MenuManipulationRequest(String menuName, String category) {
        this.menuName = menuName;
        this.category = category;
    }

    public MenuManipulationRequest(){}

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
}
