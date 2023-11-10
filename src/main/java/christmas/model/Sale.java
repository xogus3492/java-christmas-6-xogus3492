package christmas.model;

public enum Sale {
    CHRISTMAS_D_DAY_SALE("크리스마스 디데이 할인"),
    WEEKDAYS_SALE("평일 세일");

    private final String name;

    Sale(String name) {
        this.name = name;
    }
}
