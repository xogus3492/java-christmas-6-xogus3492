package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class Benefit {
    private final Map<Sale, Integer> benefit; // 할인 종류, 할인 금액
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
        benefit.put(Sale.CHRISTMAS_D_DAY_SALE, 1000 + date.getChristmasBenefit());
    }

    public void applyWeekdaysSale() {
        if (date.isWeekend() || !order.isExistDessert()) {
            return;
        }
        benefit.put(Sale.WEEKDAYS_SALE, order.dessertCount());
    }
}
