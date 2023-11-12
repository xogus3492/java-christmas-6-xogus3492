package christmas.controller;

import christmas.model.Benefit;
import christmas.model.Date;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printStartMessage();
        Date date = new Date(inputView.inputVisitDate());
        Order order = Order.of(inputView.inputOrderMenu());
        Benefit benefit = applyBenefit(order, new Benefit(date, order));
        outputView.printIntroductionMessage(date);
        printResult(order, benefit);
    }

    private Benefit applyBenefit(Order order, Benefit benefit) {
        if (order.totalOrderAmount() >= 10000) {
            benefit.applyChristmasDDaySale();
            benefit.applyWeekdaysSale();
            benefit.applyWeekendSale();
            benefit.applySpecialSale();
            benefit.applyGiveawayEvent();
        }
        return benefit;
    }

    private void printResult(Order order, Benefit benefit) {
        outputView.printOrderMenu(order);
        outputView.printTotalAmountBeforeSale(order);
        outputView.printGiveawayMenu(benefit);
        outputView.printBenefitHistory(benefit);
        outputView.printTotalBenefitAmount(benefit);
        outputView.printExpectationAmountAfterSale(order, benefit);
        outputView.printEventBadge(benefit);
    }
}
