package christmas.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Discount {

    // 크리스마스 할인 계산 메서드
    public static int christmasDiscount(LocalDate visitDate) {
        // 12월 1일부터 크리스마스까지의 기간 계산
        long daysUntilChristmas = ChronoUnit.DAYS.between(LocalDate.of(visitDate.getYear(), 12, 1), visitDate);

        // 할인액 계산 (12월 1일부터 1000원에서 매일 100원씩 증가)
        int discountAmount = 1000 + (int) (daysUntilChristmas * 100);

        // 최대 할인액을 3400원으로 제한
        return Math.min(discountAmount, 3400);
    }
}
