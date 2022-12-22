package de.htwberlin.webtech.web.api;

public class Extra {
    private Long id;
    private String extraName;
    private String category;
    private Menu menu;

    public Extra(Long id, String extraName, String category, Menu menu) {
        this.id = id;
        this.extraName = extraName;
        this.category = category;
        this.menu = menu;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtraName() {
        return extraName;
    }

    public void setExtraName(String extraName) {
        this.extraName = extraName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Menu getMenu() { return menu; }

    public void setMenu(Menu menu) { this.menu = menu; }
}
