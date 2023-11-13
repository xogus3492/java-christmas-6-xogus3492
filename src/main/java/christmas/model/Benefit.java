package christmas.model;

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
        benefit.put(Event.CHRISTMAS_D_DAY_SALE, 1000 + date.getChristmasBenefit());
    }

    public void applyWeekdaysSale() {
        if (date.isWeekend() || !order.isExistDessert()) {
            return;
        }
        benefit.put(Event.WEEKDAYS_SALE, 2023 * order.dessertCount());
    }

    public void applyWeekendSale() {
        if (!date.isWeekend() || !order.isExistMain()) {
            return;
        }
        benefit.put(Event.WEEKEND_SALE, 2023 * order.mainCount());
    }

    public void applySpecialSale() {
        if (!date.isSpecialDay()) {
            return;
        }
        benefit.put(Event.SPECIAL_SALE, 1000);
    }

    public void applyGiveawayEvent() {
        if (order.totalOrderAmount() < 120000) {
            return;
        }
        benefit.put(Event.GIVEAWAY_EVENT, 25000);
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
        if (totalBenefitAmount > 20000) {
            return "산타";
        }
        if (totalBenefitAmount > 10000) {
            return "트리";
        }
        if (totalBenefitAmount > 5000) {
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
