package christmas.view;

import christmas.model.Benefit;
import christmas.model.Date;
import christmas.model.Order;
import christmas.util.NumberFormatter;
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
                        + NumberFormatter.formulateNumber(order.totalOrderAmount()) + "원" + "\n"
        );
    }

    public void printGiveawayMenu(Benefit benefit) {
        System.out.println(PrintMessage.GIVEAWAY_MENU_OUTPUT_MESSAGE.getMessage());
        System.out.println(benefit.getGiveawayMenuByCase() + "\n");
    }

    public void printBenefitHistory(Benefit benefit) {
        System.out.println(PrintMessage.BENEFIT_HISTORY_OUTPUT_MESSAGE.getMessage());
        System.out.println(benefit);
    }

    public void printTotalBenefitAmount(Benefit benefit) {
        System.out.println(PrintMessage.TOTAL_BENEFIT_AMOUNT_OUTPUT_MESSAGE.getMessage());
        System.out.printf("-" + NumberFormatter.formulateNumber(benefit.totalBenefitAmount()) + "원\n\n");
    }

    public void printExpectationAmountAfterSale(Order order, Benefit benefit) {
        System.out.println(PrintMessage.EXPECTATION_AMOUNT_AFTER_SALE_OUTPUT_MESSAGE.getMessage());
        System.out.println(NumberFormatter.formulateNumber(
                        order.totalOrderAmount() - benefit.totalSaleAmount()
                ) + "원\n");
    }

    public void printEventBadge(Benefit benefit) {
        System.out.println(PrintMessage.EVENT_BADGE_OUTPUT_MESSAGE.getMessage());
        System.out.println(benefit.getBadgeByTotalSaleAmount());
    }
}
