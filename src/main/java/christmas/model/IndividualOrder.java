package christmas.model;

import christmas.dto.MenuDTO;
import christmas.dto.OrderDTO;
import java.util.HashMap;
import java.util.Map;

public class IndividualOrder {
    private static final String INVALID_ORDER_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String DUPLICATE_ORDER_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String ONLY_BEVERAGE_ORDER_ERROR = "[ERROR] 음료만 주문하는 것은 불가능 합니다. 다시 입력해 주세요.";
    private final Map<String, Integer> orderedItems = new HashMap<>();
    private final RestaurantMenu menu;

    public IndividualOrder(RestaurantMenu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("[ERROR] Menu cannot be null.");
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
            throw new IllegalArgumentException(DUPLICATE_ORDER_ERROR);
        }
        else if (checkBeverageOrder(orderDTO)) {
            throw new IllegalArgumentException(ONLY_BEVERAGE_ORDER_ERROR);
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

    public boolean checkBeverageOrder(OrderDTO orderDTO) {
        String menuName = orderDTO.getMenuName();
        MenuDTO menuDTO = menu.getMenuItemByName(menuName);

        // 음료인 경우 true를 반환, 아닌 경우 false를 반환
        return menuDTO != null && menuDTO.getCategory() == RestaurantMenu.MenuCategory.BEVERAGE;
    }

    private boolean isValidOrder(String menuName, int quantity) {
        return menu.getMenuItemByName(menuName) != null && quantity > 0;
    }

    private boolean isDuplicate(String menuName) {
        return !orderedItems.containsKey(menuName);
    }
}
