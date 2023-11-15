package christmas.model;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {
    @Test
    void testChristmasDiscount() {
        LocalDate december25 = LocalDate.of(2023, 12, 25);
        int discountDecember25 = Discount.christmasDiscount(december25);
        assertEquals(3400, discountDecember25);
    }

    @Test
    void testWeekdayDessertDiscount() {
        LocalDate weekdayDate = LocalDate.of(2023, 12, 4);
        int desertDiscount = Discount.weekdayDessertDiscount(3, weekdayDate);
        assertEquals(6069, desertDiscount);
    }

    @Test
    void testWeekendMainDiscount() {
        LocalDate fridayDate = LocalDate.of(2023, 12, 1);
        int menuDiscount = Discount.weekendMenuDiscount(2, fridayDate);
        assertEquals(4046, menuDiscount);
    }

    @Test
    void testSpecialDiscount_WithStar() {
        LocalDate starDate = LocalDate.of(2023, 12, 25);
        int specialDiscount = Discount.specialDiscount(starDate);
        assertEquals(1000, specialDiscount);
    }

    @Test
    void testSpecialDiscount_WithoutStar() {
        LocalDate regularDate = LocalDate.of(2023, 12, 10);
        int specialDiscount = Discount.specialDiscount(regularDate);
        assertEquals(0, specialDiscount);
    }
}