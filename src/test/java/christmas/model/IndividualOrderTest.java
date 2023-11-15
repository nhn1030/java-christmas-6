package christmas.model;

import christmas.dto.MenuDTO;
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
                () -> order.addItemToOrder(nonExistingMenuName, quantity));

        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", exception.getMessage());
    }

    @Test
    void testAddItemToOrder_InvalidQuantity() {
        // 유효하지 않은 메뉴 주문 (음수 개수)
        String invalidMenuName = "티본스테이크";
        int invalidQuantity = -1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> order.addItemToOrder(invalidMenuName, invalidQuantity));

        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", exception.getMessage());
    }


//    @Test
//    void testCalculateTotalPrice() {
//        IndividualOrder order = new IndividualOrder();
//
//        // 가격이 일치하는지 확인할 메뉴
//        String matchMenuName = "티본스테이크";
//        int OrderQuantity = 2;
//
//        // 메뉴를 주문에 추가
//        order.addItemToOrder(matchMenuName, OrderQuantity);
//
//        // 해당하는 메뉴의 menuDTO를 가져와 주문가격이 일치하는 지 확인
//        MenuDTO menuDTO = new RestaurantMenu().getMenuItemByName(matchMenuName);
//        int expectedTotalPrice = menuDTO.getPrice() * OrderQuantity;
//
//        assertEquals(expectedTotalPrice, order.calculateTotalPrice());
//        assertNotEquals(30000, order.calculateTotalPrice());
//    }
}
