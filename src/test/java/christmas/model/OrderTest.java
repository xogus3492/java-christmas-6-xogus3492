package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @Test
    void 티본스테이크1개와_바비큐립1개를_주문하면_총주문_금액_109000원을_반환한다() {
        //given
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("티본스테이크", 1);
        orderMenu.put("바비큐립", 1);
        Order order = Order.of(orderMenu);

        //when
        final int totalAmount = order.totalOrderAmount();

        //then
        assertThat(totalAmount).isEqualTo(109000);
    }

    @Test
    void 티본스테이크1개와_초코케이크1개를_주문하면_디저트가_존재한다() {
        //given
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("티본스테이크", 1);
        orderMenu.put("초코케이크", 1);
        Order order = Order.of(orderMenu);

        //when
        final boolean existDessert = order.isExistDessert();

        //then
        assertThat(existDessert).isTrue();
    }
}
