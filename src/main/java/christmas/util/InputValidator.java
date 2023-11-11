package christmas.util;

import christmas.error.ErrorMessage;
import christmas.model.Date;
import christmas.model.Menu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
            List<String> names = InputParser.parseMenuList(input);
            List<Menu> menus = verifyMenuExistAndGetIt(names);
            verifyOnlyDrink(menus);
            verifyDuplicateMenu(menus);
            verifyNumberOfMenu(input);
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

    private static void verifyForm(String input) {
        String regex = "^([가-힣]+-[1-9]+,)*[가-힣]+-[1-9]+$";
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static List<Menu> verifyMenuExistAndGetIt(List<String> input) {
        List<Menu> menus = new ArrayList<>();
        for (String name : input) {
            menus.add(Menu.getMenu(name));
        }
        return menus;
    }

    private static void verifyOnlyDrink(List<Menu> menus) {
        menus.stream()
                .filter(menu -> !menu.isDrink())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ONLY_DRINK_MENU.getMessage()));
    }

    private static void verifyDuplicateMenu(List<Menu> menus) {
        if (new HashSet<>(menus).size() != menus.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static void verifyNumberOfMenu(String input) {
        int count = InputParser.parseNumberOfMenu(input);
        if (count > 20) {
            throw new IllegalArgumentException(ErrorMessage.OVER_NUMBER_OF_MENU.getMessage());
        }
    }

    private InputValidator() {
    }
}