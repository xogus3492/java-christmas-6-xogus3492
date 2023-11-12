package christmas.model;

import christmas.error.ErrorMessage;

public class Date {
    private final int day;

    public Date(int day) {
        verifyValidRange(day);
        this.day = day;
    }

    public void verifyValidRange(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_VISIT_DATE.getMessage());
        }
    }

    public boolean isUnderTwentySix() {
        return day < 26;
    }

    public int getChristmasBenefit() {
        return (day - 1) * 100;
    }

    public boolean isWeekend() {
        return (day % 7 == 1) || (day % 7 == 2);
    }

    public boolean isSpecialDay() {
        return (day % 7 == 3) || (day == 25);
    }

    public int getDay() {
        return day;
    }
}
