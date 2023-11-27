package christmas.util;

import java.text.DecimalFormat;

public class NumberFormatter {

    public static String formulateNumber(int number) {
        return new DecimalFormat("###,###").format(number);
    }

    private NumberFormatter() {
    }
}
