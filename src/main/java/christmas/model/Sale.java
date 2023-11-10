package christmas.model;

public enum Sale {
    CHRISTMAS_D_DAY_SALE("크리스마스 디데이 할인"),
    WEEKDAYS_SALE("평일 할인"),
    WEEKEND_SALE("주말 할인"),
    SPECIAL_SALE("특별 할인");

    private final String name;

    Sale(String name) {
        this.name = name;
    }
}
