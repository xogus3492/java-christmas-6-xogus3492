package christmas.util;

import christmas.error.ErrorMessage;
import christmas.model.Date;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String EMPTY = "";
    private static final String SPACE = " ";

    public static boolean verifyVisitDate(String input) {
        try {
            verifyEmptyOrBlank(input);
            int integerInput = Integer.parseInt(input);
            new Date(integerInput);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.NOT_COMPOSED_OF_NUMBER.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean verifyOrderMenu(String input) {
        try {
            verifyForm(input);
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

    public static void verifyForm(String input) {
        String regex = "^([가-힣]+-[1-9]+,)*[가-힣]+-[1-9]+$";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private InputValidator() {
    }
}
