package christmas.view;

import christmas.model.Date;
import christmas.view.message.PrintMessage;

public class OutputView {

    public void printStartMessage() {
        System.out.println(PrintMessage.START_OUTPUT_MESSAGE.getMessage());
    }

    public void printIntroductionMessage(Date date) {
        System.out.printf(PrintMessage.INTRODUCTION_OUTPUT_MESSAGE.getMessage() + "\n", date.getDay());
    }
}
