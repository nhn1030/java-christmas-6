package christmas.model;

import christmas.dto.MenuDTO;
import java.util.HashMap;
import java.util.Map;

public class RestaurantMenu {
    public enum MenuCategory {
        APPETIZER,
        MAIN,
        DESSERT,
        BEVERAGE;
    }
    private static final Map<String, MenuDTO> menuItems = new HashMap<>();

    public RestaurantMenu() {
        initializeMenu();
    }
    private static void initializeMenu() {
        // 애피타이저
        menuItems.put("양송이수프", new MenuDTO("양송이수프", 6000, MenuCategory.APPETIZER));
        menuItems.put("타파스", new MenuDTO("타파스", 5500, MenuCategory.APPETIZER));
        menuItems.put("시저샐러드", new MenuDTO("시저샐러드", 8000, MenuCategory.APPETIZER));

        // 메인
        menuItems.put("티본스테이크", new MenuDTO("티본스테이크", 55000, MenuCategory.MAIN));
        menuItems.put("바비큐립", new MenuDTO("바비큐립", 54000, MenuCategory.MAIN));
        menuItems.put("해산물파스타", new MenuDTO("해산물파스타", 35000, MenuCategory.MAIN));
        menuItems.put("크리스마스파스타", new MenuDTO("크리스마스파스타", 25000, MenuCategory.MAIN));

        // 디저트
        menuItems.put("초코케이크", new MenuDTO("초코케이크", 15000, MenuCategory.DESSERT));
        menuItems.put("아이스크림", new MenuDTO("아이스크림", 5000, MenuCategory.DESSERT));

        // 음료
        menuItems.put("제로콜라", new MenuDTO("제로콜라", 3000, MenuCategory.BEVERAGE));
        menuItems.put("레드와인", new MenuDTO("레드와인", 60000, MenuCategory.BEVERAGE));
        menuItems.put("샴페인", new MenuDTO("샴페인", 25000, MenuCategory.BEVERAGE));
    }
    public MenuDTO getMenuItemByName(String menuName) {
        return menuItems.get(menuName);
    }

    public Map<String, MenuDTO> getMenuByCategory(MenuCategory category) {
        Map<String, MenuDTO> result = new HashMap<>();
        for (Map.Entry<String, MenuDTO> entry : menuItems.entrySet()) {
            if (entry.getValue().getCategory() == category) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
