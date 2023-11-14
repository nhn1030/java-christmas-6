package christmas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

public class DiscountTest {
    @Test
    // 크리스마스 할인이 올바르게 계산되는지 테스트
    void testChristmasDiscount() {
        LocalDate december2 = LocalDate.of(2023, 12, 1);
        int discountDicember2 = Discount.christmasDiscount(december2);
        assertEquals(1000, discountDicember2);
    }
}
