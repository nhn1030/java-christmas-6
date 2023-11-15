package christmas.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class Discount {
    private static final int CHRISTMAS_DAY = 25;
    public enum DiscountConstants {
        BASE_DISCOUNT(1000),
        DAILY_INCREASE(100),
        MAX_DISCOUNT(3400),
        DAYS_OFFSET(1),
        WEEKDAY_DESSERT_DISCOUNT(2023),
        WEEKEND_DESSERT_DISCOUNT(2023),
        SPECIAL_DISCOUNT(1000);

        private final int value;

        DiscountConstants(int value) {
            this.value = value;
        }
    }

    public static int christmasDiscount(LocalDate visitDate) {
        int daysUntilChristmas = visitDate.getDayOfMonth() - DiscountConstants.DAYS_OFFSET.value;
        int discountAmount = DiscountConstants.BASE_DISCOUNT.value +
                (daysUntilChristmas * DiscountConstants.DAILY_INCREASE.value);

        return Math.min(discountAmount, DiscountConstants.MAX_DISCOUNT.value);
    }

    public static int weekdayDessertDiscount(int numberOfDessert, LocalDate visitDate) {
        if (isWeekday(visitDate.getDayOfWeek())) {
            return numberOfDessert * DiscountConstants.WEEKDAY_DESSERT_DISCOUNT.value;
        }
        return 0;
    }

    public static int weekendMenuDiscount(int numberOfMain, LocalDate visitDate) {
        if (isWeekend(visitDate.getDayOfWeek())) {
            return numberOfMain * DiscountConstants.WEEKEND_DESSERT_DISCOUNT.value;
        }
        return 0;
    }

    public static int specialDiscount(LocalDate visitDate) {
        if (isStarDate(visitDate)) {
            return DiscountConstants.SPECIAL_DISCOUNT.value;
        }
        return 0;
    }

    private static boolean isWeekday(DayOfWeek dayOfWeek) {
        return !dayOfWeek.equals(DayOfWeek.FRIDAY) && !dayOfWeek.equals(DayOfWeek.SATURDAY);
    }

    private static boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }

    private static boolean isStarDate(LocalDate visitDate) {
        return visitDate.getMonth() == Month.DECEMBER &&
                (visitDate.getDayOfWeek() == DayOfWeek.SUNDAY || visitDate.getDayOfMonth() == CHRISTMAS_DAY);
    }

}
