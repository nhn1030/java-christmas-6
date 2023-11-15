package christmas.model;

import christmas.dto.MenuDTO;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;




public class RestaurantMenuTest {
    private RestaurantMenu menuItem;
    @BeforeEach
    public void setUp() {
        menuItem = new RestaurantMenu();
    }

    @Test
    void testGetMenuItem_ExistingMenu() {
        RestaurantMenu menu = new RestaurantMenu();
        String menuName = "티본스테이크";

        MenuDTO menuDTO = menu.getMenuItemByName(menuName);

        assertNotNull(menuDTO);
        assertEquals(menuName, menuDTO.getName());
    }



    @Test
    public void testGetMenuByCategory() {
        RestaurantMenu.MenuCategory categoryToTest = RestaurantMenu.MenuCategory.APPETIZER;

        Map<String, MenuDTO> result = menuItem.getMenuByCategory(categoryToTest);


        assertEquals(3, result.size());
        assertEquals("양송이수프", result.get("양송이수프").getName());
        assertEquals("타파스", result.get("타파스").getName());
        assertEquals("시저샐러드", result.get("시저샐러드").getName());
    }
}
