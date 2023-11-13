package christmas.model;

public enum Event {
    CHRISTMAS_D_DAY_SALE("크리스마스 디데이 할인", 1000),
    WEEKDAYS_SALE("평일 할인", 2023),
    WEEKEND_SALE("주말 할인", 2023),
    SPECIAL_SALE("특별 할인", 1000),
    GIVEAWAY_EVENT("증정 이벤트", 25000);

    private final String name;
    private final int discount;

    Event(String name, int discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }
}
