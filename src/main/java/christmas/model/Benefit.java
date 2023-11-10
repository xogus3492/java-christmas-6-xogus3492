package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class Benefit {
    private final Map<Sale, Integer> benefit; // 할인 종류, 할인 금액
    private final Date date;

    public Benefit(Date date) {
        this.benefit = new HashMap<>();
        this.date = date;
    }

    public void applyChristmasDDaySale() {
        if (!date.isUnderTwentySix()) {
            return;
        }
        benefit.put(Sale.CHRISTMAS_D_DAY_SALE, 1000 + date.getChristmasBenefit());
    }
}
