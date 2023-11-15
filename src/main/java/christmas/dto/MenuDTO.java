package christmas.dto;

import christmas.model.RestaurantMenu.MenuCategory;

public class MenuDTO {
    private final String name;
    private final int price;
    private final MenuCategory category;

    public MenuDTO(String name, int price, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuCategory getCategory() {
        return category;
    }
}
