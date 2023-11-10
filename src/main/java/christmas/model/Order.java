package christmas.model;

import java.util.Map;

public class Order {
    private final Map<Menu, Integer> orderMenu; // <메뉴, 수량>

    public Order(Map<Menu, Integer> orderMenu) {
        this.orderMenu = orderMenu;
    }

    public int totalOrderAmount() {
        return orderMenu.keySet().stream()
                .mapToInt(menu -> menu.getPrice() * orderMenu.get(menu))
                .sum();
    }
}
