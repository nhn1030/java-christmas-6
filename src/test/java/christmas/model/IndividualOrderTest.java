package christmas.model;

import christmas.dto.MenuDTO;
import christmas.dto.OrderDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class IndividualOrderTest {
    IndividualOrder order = new IndividualOrder(new RestaurantMenu());

    @Test
    void testAddItemToOrder_NotExistingMenu() {
        // 존재하지 않는 메뉴 주문
        String nonExistingMenuName = "아이스아메리카노";
        int quantity = 1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> order.addItemToOrder(new OrderDTO(nonExistingMenuName, quantity)));

        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", exception.getMessage());
    }

    @Test
    void testAddItemToOrder_InvalidQuantity() {
        // 유효하지 않은 메뉴 주문 (음수 개수)
        String invalidMenuName = "티본스테이크";
        int invalidQuantity = -1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> order.addItemToOrder(new OrderDTO(invalidMenuName, invalidQuantity)));

        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", exception.getMessage());
    }

    @Test
    void testAddItemToOrder_DuplicateMenu() {
        // 중복된 입력 검증
        String menuName = "티본스테이크";
        int quantity = 1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> order.addItemToOrder(new OrderDTO(menuName, quantity)));

        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", exception.getMessage());
    }
}
