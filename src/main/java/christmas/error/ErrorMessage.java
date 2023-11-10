package christmas.error;

public enum ErrorMessage {
    NOT_EMPTY_OR_BLANK("공백이 존재하거나 값이 비어있으면 안됩니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}