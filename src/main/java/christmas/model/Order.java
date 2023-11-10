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

    public boolean isExistDessert() {
        int count = (int) orderMenu.keySet().stream()
                .filter(menu -> menu.isDessert())
                .count();
        return count > 0;
    }

    public int dessertCount() {
        return orderMenu.keySet().stream()
                .filter(menu -> menu.isDessert())
                .mapToInt(menu -> orderMenu.get(menu))
                .sum();
    }

    public boolean isExistMain() {
        int count = (int) orderMenu.keySet().stream()
                .filter(menu -> menu.isMain())
                .count();
        return count > 0;
    }

    public int mainCount() {
        return orderMenu.keySet().stream()
                .filter(menu -> menu.isMain())
                .mapToInt(menu -> orderMenu.get(menu))
                .sum();
    }
}
