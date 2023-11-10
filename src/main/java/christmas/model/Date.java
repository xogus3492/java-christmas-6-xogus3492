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
}
