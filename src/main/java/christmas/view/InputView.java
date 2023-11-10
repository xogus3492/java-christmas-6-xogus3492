package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.InputValidator;
import christmas.view.message.PrintMessage;

public class InputView {

    public int inputVisitDate() {
        System.out.println();
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
}
