package christmas.error;

public enum ErrorMessage {
    NOT_EMPTY_OR_BLANK("공백이 존재하거나 값이 비어있으면 안됩니다. 다시 입력해 주세요."),
    INVALID_VISIT_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ONLY_DRINK_MENU("음료만 주문하실 수 없습니다. 다시 입력해 주세요."),
    OVER_NUMBER_OF_MENU("메뉴는 20개를 초과할 수 없습니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
