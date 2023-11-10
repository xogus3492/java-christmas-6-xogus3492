package christmas.util;

import java.util.Arrays;
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

    private InputParser() {
    }
}
