package christmas.view.message;

public enum PrintMessage {
    // InputView
    VISIT_DATE_INPUT_MESSAGE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDER_MENU_INPUT_MESSAGE("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),

    // OutputView
    START_OUTPUT_MESSAGE("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    INTRODUCTION_OUTPUT_MESSAGE("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_OUTPUT_MESSAGE("<주문 메뉴>"),
    TOTAL_AMOUNT_BEFORE_SALE_OUTPUT_MESSAGE("<할인 전 총주문 금액>");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
