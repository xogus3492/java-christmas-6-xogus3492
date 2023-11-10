package christmas.model;

public class Date {
    private final int day;

    public Date(int day) {
        this.day = day;
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
}
