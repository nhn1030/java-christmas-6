package christmas.model;

import christmas.dto.MenuDTO;
import java.util.HashMap;
import java.util.Map;

public class IndividualOrder {
    private static final String INVALID_ORDER_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final Map<String, Integer> orderedItems = new HashMap<>();
    private final RestaurantMenu menu;

    public IndividualOrder(RestaurantMenu menu) {
        this.menu = menu;
    }

    public void addItemToOrder(String menuName, int quantity) {
        if (!isValidOrder(menuName, quantity)) {
            throw new IllegalArgumentException(INVALID_ORDER_ERROR);
        }
        orderedItems.put(menuName, quantity);
    }

    private boolean isValidOrder(String menuName, int quantity) {
        return menu.getMenuItemByName(menuName) != null && quantity > 0;
    }
}
