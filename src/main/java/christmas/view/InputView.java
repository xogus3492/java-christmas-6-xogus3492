package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.message.PrintMessage;

public class InputView {

    public int inputVisitDate() {
        System.out.println(PrintMessage.VISIT_DATE_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
