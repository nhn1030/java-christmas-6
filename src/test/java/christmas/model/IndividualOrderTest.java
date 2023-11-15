package christmas.model;

import christmas.dto.OrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class IndividualOrderTest {
    private IndividualOrder order;

    @BeforeEach
    void setUp() {
        RestaurantMenu menu = new RestaurantMenu();
        order = new IndividualOrder(menu);
    }

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

        // 주문 객체 생성
        IndividualOrder order = new IndividualOrder(new RestaurantMenu());

        // 첫 번째 주문
        assertDoesNotThrow(() -> order.addItemToOrder(new OrderDTO(menuName, quantity)));

        // 중복 주문 시 예외 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> order.addItemToOrder(new OrderDTO(menuName, quantity)));

        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", exception.getMessage());
    }


    @Test
    void testCalculateTotalPrice() {
        // 메뉴와 주문 생성
        RestaurantMenu menu = new RestaurantMenu();
        IndividualOrder order = new IndividualOrder(menu);

        // 주문 추가
        OrderDTO orderDTO1 = new OrderDTO("티본스테이크", 3);
        OrderDTO orderDTO2 = new OrderDTO("바비큐립", 2);
        OrderDTO orderDTO3 = new OrderDTO("시저샐러드", 1);

        order.addItemToOrder(orderDTO1);
        order.addItemToOrder(orderDTO2);
        order.addItemToOrder(orderDTO3);

        // 주문된 항목의 총 가격 계산
        int totalPrice = order.calculateTotalPrice();

        // 예상 가격과 일치하는지 확인
        assertEquals(281000, totalPrice);
    }
}