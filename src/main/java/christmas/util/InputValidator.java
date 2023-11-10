package christmas.util;

import christmas.error.ErrorMessage;

public class InputValidator {
    private static final String EMPTY = "";
    private static final String SPACE = " ";

    public static boolean verifyVisitDate(String input) {
        try {
            verifyEmptyOrBlank(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static void verifyEmptyOrBlank(String input) {
        if (input.equals(EMPTY) || input.equals(SPACE)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EMPTY_OR_BLANK.getMessage());
        }
    }

    private InputValidator() {
    }
}
