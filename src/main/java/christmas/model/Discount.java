package christmas.model;

import java.time.LocalDate;

public class Discount {

    private static final int BASE_DISCOUNT = 1000;
    private static final int DAILY_INCREASE = 100;
    private static final int MAX_DISCOUNT = 3400;
    private static final int DAYS_OFFSET = 1;

    // 크리스마스 할인 계산 메서드
    public static int christmasDiscount(LocalDate visitDate) {
        int daysUntilChristmas = visitDate.getDayOfMonth() - DAYS_OFFSET;
        int discountAmount = BASE_DISCOUNT + (daysUntilChristmas * DAILY_INCREASE);

        return Math.min(discountAmount, MAX_DISCOUNT);
    }
}
