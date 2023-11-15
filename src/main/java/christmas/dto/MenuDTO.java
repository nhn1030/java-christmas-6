package christmas.dto;

public class MenuDTO {
    private final String name;
    private final int price;

    public MenuDTO(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
