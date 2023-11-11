package christmas.model;

import christmas.error.ErrorMessage;
import java.util.Arrays;

public enum Menu {

    // 에피타이저
    BUTTON_MUSHROOM_SOUP("양송이수프", "애피타이저", 6000),
    TAPAS("타파스", "애피타이저", 5500),
    CAESAR_SALAD("시저샐러드", "애피타이저", 8000),

    // 메인

    T_BONE_STEAK("티본스테이크", "메인", 55000),
    BARBECUE_RIBS("바비큐립", "메인", 54000),
    SEAFOOD_PASTA("해산물파스타", "메인", 35000),

    CHRISTMAS_PASTA("크리스마스파스타", "메인", 25000),

    // 디저트
    CHOCOLATE_CAKE("초코케이크", "디저트", 15000),
    ICE_CREAM("아이스크림", "디저트", 5000),

    // 음료
    ZERO_COLA("제로콜라", "음료", 3000),
    RED_WINE("레드와인", "음료", 60000),
    CHAMPAGNE("샴페인", "음료", 25000);

    private final String name;
    private final String type;
    private final int price;

    Menu(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean isDessert() {
        return this.type.equals("디저트");
    }

    public boolean isMain() {
        return this.type.equals("메인");
    }

    public static Menu verifyExistMenuAndOnlyDrink(String name) {
        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage()));
    }
}
