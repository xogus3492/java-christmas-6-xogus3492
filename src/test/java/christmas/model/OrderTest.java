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

    @Test
    void 아이스크림2개와_초코케이크1개를_주문하면_디저트_갯수_3을_반환한다() {
        //given
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("아이스크림", 2);
        orderMenu.put("초코케이크", 1);
        Order order = Order.of(orderMenu);

        //when
        final int dessertCount = order.dessertCount();

        //then
        assertThat(dessertCount).isEqualTo(3);
    }

    @Test
    void 바비큐립1개와_초코케이크1개를_주문하면_메인메뉴가_존재한다() {
        //given
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("바비큐립", 1);
        orderMenu.put("초코케이크", 1);
        Order order = Order.of(orderMenu);

        //when
        final boolean existMain = order.isExistMain();

        //then
        assertThat(existMain).isTrue();
    }

    @Test
    void 바비큐립2개와_해산물파스타1개를_주문하면_메인메뉴_갯수_3을_반환한다() {
        //given
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("바비큐립", 2);
        orderMenu.put("해산물파스타", 1);
        Order order = Order.of(orderMenu);

        //when
        final int mainCount = order.mainCount();

        //then
        assertThat(mainCount).isEqualTo(3);
    }

    @Test
    void 바비큐립1개와_타파스1개와_샴페인2개를_주문하면_주문내역을_반환한다() {
        //given
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("바비큐립", 1);
        orderMenu.put("타파스", 1);
        orderMenu.put("샴페인", 2);
        Order order = Order.of(orderMenu);

        //when
        final String orderCondition = order.toString();

        //then
        assertThat(orderCondition).contains("바비큐립 1개", "타파스 1개", "샴페인 2개");
    }
}
