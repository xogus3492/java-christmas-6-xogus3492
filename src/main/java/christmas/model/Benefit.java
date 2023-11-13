package christmas.model;

import christmas.policy.EventPolicy;
import christmas.util.NumberFormatter;
import java.util.HashMap;
import java.util.Map;

public class Benefit {
    private final Map<Event, Integer> benefit; // 할인 종류, 할인 금액
    private final Date date;
    private final Order order;

    public Benefit(Date date, Order order) {
        this.benefit = new HashMap<>();
        this.date = date;
        this.order = order;
    }

    public void applyChristmasDDaySale() {
        if (!date.isUnderTwentySix()) {
            return;
        }
        benefit.put(Event.CHRISTMAS_D_DAY_SALE,
                Event.CHRISTMAS_D_DAY_SALE.getDiscount() + date.getChristmasBenefit());
    }

    public void applyWeekdaysSale() {
        if (date.isWeekend() || !order.isExistDessert()) {
            return;
        }
        benefit.put(Event.WEEKDAYS_SALE,
                Event.WEEKDAYS_SALE.getDiscount() * order.dessertCount());
    }

    public void applyWeekendSale() {
        if (!date.isWeekend() || !order.isExistMain()) {
            return;
        }
        benefit.put(Event.WEEKEND_SALE,
                Event.WEEKEND_SALE.getDiscount() * order.mainCount());
    }

    public void applySpecialSale() {
        if (!date.isSpecialDay()) {
            return;
        }
        benefit.put(Event.SPECIAL_SALE, Event.SPECIAL_SALE.getDiscount());
    }

    public void applyGiveawayEvent() {
        if (order.totalOrderAmount() < EventPolicy.GIVEAWAY_EVENT_CONSTRAINT.getLimit()) {
            return;
        }
        benefit.put(Event.GIVEAWAY_EVENT, Event.GIVEAWAY_EVENT.getDiscount());
    }

    public String getGiveawayMenuByCase() {
        if (benefit.containsKey(Event.GIVEAWAY_EVENT)) {
            return "샴페인 1개";
        }
        return "없음";
    }

    public int totalBenefitAmount() {
        return benefit.keySet().stream()
                .mapToInt(event -> benefit.get(event))
                .sum();
    }

    public int totalSaleAmount() {
        return benefit.keySet().stream()
                .filter(event -> event != Event.GIVEAWAY_EVENT)
                .mapToInt(event -> benefit.get(event))
                .sum();
    }

    public String getBadgeByTotalSaleAmount() {
        int totalBenefitAmount = totalBenefitAmount();
        if (totalBenefitAmount > EventPolicy.SANTA_BADGE_CONSTRAINT.getLimit()) {
            return "산타";
        }
        if (totalBenefitAmount > EventPolicy.TREE_BADGE_CONSTRAINT.getLimit()) {
            return "트리";
        }
        if (totalBenefitAmount > EventPolicy.STAR_BADGE_CONSTRAINT.getLimit()) {
            return "별";
        }
        return "없음";
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Event event : benefit.keySet()) {
            stringBuilder.append(event.getName()
                    + ": -" + NumberFormatter.formulateNumber(benefit.get(event)
            ) + "원\n");
        }
        if (stringBuilder.toString().equals("")) {
            stringBuilder.append("없음\n");
        }
        return stringBuilder.toString();
    }
}
