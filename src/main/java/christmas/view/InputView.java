package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.InputParser;
import christmas.util.InputValidator;
import christmas.view.message.PrintMessage;
import java.util.Map;

public class InputView {

    public int inputVisitDate() {
        String input;
        while(true) {
            System.out.println(PrintMessage.VISIT_DATE_INPUT_MESSAGE.getMessage());
            input = Console.readLine();
            if (InputValidator.verifyVisitDate(input)) {
                break;
            }
        }
        return Integer.parseInt(input);
    }

    public Map<String, Integer> inputOrderMenu() {
        System.out.println(PrintMessage.ORDER_MENU_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        return InputParser.parseMap(input);
    }
}
