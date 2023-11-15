package christmas.model;

import java.time.LocalDate;

public class Discount {

    public enum DiscountConstants {
        BASE_DISCOUNT(1000),
        DAILY_INCREASE(100),
        MAX_DISCOUNT(3400),
        DAYS_OFFSET(1);

        private final int value;

        DiscountConstants(int value) {
            this.value = value;
        }
    }

    // 크리스마스 할인 계산 메서드
    public static int christmasDiscount(LocalDate visitDate) {
        int daysUntilChristmas = visitDate.getDayOfMonth() - DiscountConstants.DAYS_OFFSET.value;
        int discountAmount = DiscountConstants.BASE_DISCOUNT.value +
                (daysUntilChristmas * DiscountConstants.DAILY_INCREASE.value);

        return Math.min(discountAmount, DiscountConstants.MAX_DISCOUNT.value);
    }
}
