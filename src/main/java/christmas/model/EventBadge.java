package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class EventBadge {
    private static final List<EventBadge> badges = new ArrayList<>();

    private String badgeName;  // Badge 클래스와 동일한 필드명으로 변경

    public EventBadge(String badgeName) {
        this.badgeName = badgeName;
    }

    static {
        badges.add(new EventBadge("별"));
        badges.add(new EventBadge("트리"));
        badges.add(new EventBadge("산타"));
    }

    public static EventBadge decideBadge(double benefitAmount) {
        if (benefitAmount >= 20000) {
            return badges.get(2);
        }
        if (benefitAmount >= 10000) {
            return badges.get(1);
        }
        if (benefitAmount >= 5000) {
            return badges.get(0);
        }
        return null;
    }

    public String getBadgeName() {
        return badgeName;
    }
}
