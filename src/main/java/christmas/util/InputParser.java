package christmas.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputParser {

    public static Map<String, Integer> parseMap(String input) {
        return Arrays.stream(input.split(","))
                .map(order -> order.split("-"))
                .collect(Collectors.toMap(
                        order -> order[0],
                        order -> Integer.parseInt(order[1])
                ));
    }

    public static List<String> parseMenuList(String input) {
        return Arrays.stream(input.split(","))
                .map(order -> order.split("-")[0])
                .collect(Collectors.toList());
    }

    public static int parseNumberOfMenu(String input) {
        return Arrays.stream(input.split(","))
                .mapToInt(order -> Integer.parseInt(
                        order.split("-")[1]
                ))
                .sum();
    }

    private InputParser() {
    }
}
