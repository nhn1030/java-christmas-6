package christmas;

import christmas.model.Discount;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTest {
    @Test
        // 크리스마스 할인이 올바르게 계산되는지 테스트
    void testChristmasDiscount() {
        LocalDate december25 = LocalDate.of(2023, 12, 25);
        int discountDecember25 = Discount.christmasDiscount(december25);
        assertEquals(3400, discountDecember25);
    }
}