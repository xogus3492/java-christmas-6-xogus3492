package christmas.view;

import christmas.model.Date;
import christmas.model.Order;
import christmas.view.message.PrintMessage;

public class OutputView {

    public void printStartMessage() {
        System.out.println(PrintMessage.START_OUTPUT_MESSAGE.getMessage());
    }

    public void printIntroductionMessage(Date date) {
        System.out.printf(PrintMessage.INTRODUCTION_OUTPUT_MESSAGE.getMessage() + "\n\n", date.getDay());
    }

    public void printOrderMenu(Order order) {
        System.out.println(PrintMessage.ORDER_MENU_OUTPUT_MESSAGE.getMessage() + "\n" + order.toString());
    }

    public void printTotalAmountBeforeSale(Order order) {
        System.out.println(
                PrintMessage.TOTAL_AMOUNT_BEFORE_SALE_OUTPUT_MESSAGE.getMessage() + "\n"
                        + order.totalOrderAmount() + "원"
        );
    }
}
