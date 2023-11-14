package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BenefitTest {

    @Test
    void 예약날짜가_3일이라면_크리스마스_디데이_할인에_의해_1200원이_할인된다() {
        //given
        Date date = new Date(3);

        Map<String, Integer> orderMenu = new HashMap<>();
        Order order = Order.of(orderMenu);

        Benefit benefit = new Benefit(date, order);

        //when
        benefit.applyChristmasDDaySale();

        //then
        assertThat(benefit.toString()).contains("크리스마스 디데이 할인: -1,200원");
    }

    @Test
    void 평일에_디저트2개를_주문하면_평일_할인에_의해_4046원이_할인된다() {
        //given
        Date date = new Date(3);

        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("초코케이크", 1);
        orderMenu.put("아이스크림", 1);
        Order order = Order.of(orderMenu);

        Benefit benefit = new Benefit(date, order);

        //when
        benefit.applyWeekdaysSale();

        //then
        assertThat(benefit.toString()).contains("평일 할인: -4,046원");
    }

    @Test
    void 주말에_메인메뉴2개를_주문하면_주말_할인에_의해_4046원이_할인된다() {
        //given
        Date date = new Date(2);

        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("바비큐립", 1);
        orderMenu.put("크리스마스파스타", 1);
        Order order = Order.of(orderMenu);

        Benefit benefit = new Benefit(date, order);

        //when
        benefit.applyWeekendSale();

        //then
        assertThat(benefit.toString()).contains("주말 할인: -4,046원");
    }

    @Test
    void 특별_지정날에_주문하면_특별_할인에_의해_1000원이_할인된다() {
        //given
        Date date = new Date(25);

        Map<String, Integer> orderMenu = new HashMap<>();
        Order order = Order.of(orderMenu);

        Benefit benefit = new Benefit(date, order);

        //when
        benefit.applySpecialSale();

        //then
        assertThat(benefit.toString()).contains("특별 할인: -1,000원");
    }
}
