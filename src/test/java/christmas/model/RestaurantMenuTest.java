package christmas.model;

import christmas.dto.MenuDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class RestaurantMenuTest {
    @Test
    void testGetMenuItem_ExistingMenu() {
        RestaurantMenu menu = new RestaurantMenu();
        String menuName = "티본스테이크";

        MenuDTO menuDTO = menu.getMenuItemByName(menuName);

        assertNotNull(menuDTO);
        assertEquals(menuName, menuDTO.getName());
    }
}
