package christmas.model;

import christmas.dto.MenuDTO;
import christmas.dto.OrderDTO;
import java.util.HashMap;
import java.util.Map;

public class IndividualOrder {
    private static final String INVALID_ORDER_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private final Map<String, Integer> orderedItems = new HashMap<>();
    private final RestaurantMenu menu;

    public IndividualOrder(RestaurantMenu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("Menu cannot be null.");
        }
        this.menu = menu;
    }

    public void addItemToOrder(OrderDTO orderDTO) {
        String menuName = orderDTO.getMenuName();
        int quantity = orderDTO.getQuantity();

        if (!isValidOrder(menuName, quantity)) {
            throw new IllegalArgumentException(INVALID_ORDER_ERROR);
        }

        else if (!isDuplicate(menuName)) {
            throw new IllegalArgumentException(INVALID_ORDER_ERROR);
        }

        orderedItems.put(menuName, quantity);
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Map.Entry<String, Integer> entry : orderedItems.entrySet()) {
            String menuName = entry.getKey();
            int quantity = entry.getValue();

            MenuDTO menuDTO = menu.getMenuItemByName(menuName);
            int menuPrice = menuDTO.getPrice();

            totalPrice += menuPrice * quantity;
        }

        return totalPrice;
    }



    private boolean isValidOrder(String menuName, int quantity) {
        return menu.getMenuItemByName(menuName) != null && quantity > 0;
    }

    private boolean isDuplicate(String menuName) {
        return !orderedItems.containsKey(menuName);
    }
}
