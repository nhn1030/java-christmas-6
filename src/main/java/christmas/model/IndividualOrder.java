package christmas.model;

import christmas.dto.MenuDTO;
import java.util.HashMap;
import java.util.Map;

public class IndividualOrder {
    private final Map<String, Integer> orderedItems = new HashMap<>();
    private final RestaurantMenu menu = new RestaurantMenu();

    public void addItemToOrder(String menuName, int quantity) {
        if (menu.getMenuItemByName(menuName) == null) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }

        orderedItems.put(menuName, quantity);
    }
}
