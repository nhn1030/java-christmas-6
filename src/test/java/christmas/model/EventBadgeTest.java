package christmas.model;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class EventBadgeTest {

    @Test
    void testDecideBadge_NonBenefit() {
        double benefitAmount = 200;

        // 주어진 혜택 금액에 따라 배지를 결정하고, 결과가 null인지 확인
        assertNull(EventBadge.decideBadge(benefitAmount), "혜택 금액이 0일 때 배지가 없어야 함");
    }
}
