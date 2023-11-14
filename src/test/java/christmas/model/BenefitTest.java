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

    @Test
    void 메뉴를_120000원_이상_주문하면_증정_이벤트로_25000원_혜택을_받는다() {
        //given
        Date date = new Date(3);

        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("티본스테이크", 1);
        orderMenu.put("바비큐립", 1);
        orderMenu.put("초코케이크", 2);
        orderMenu.put("제로콜라", 1);
        Order order = Order.of(orderMenu);

        Benefit benefit = new Benefit(date, order);

        //when
        benefit.applyGiveawayEvent();

        //then
        assertThat(benefit.toString()).contains("증정 이벤트: -25,000원");
    }

    @Test
    void 증정_이벤트에_해당한다면_샴페인1개를_받는다() {
        //given
        Date date = new Date(3);

        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("티본스테이크", 1);
        orderMenu.put("바비큐립", 1);
        orderMenu.put("초코케이크", 2);
        orderMenu.put("제로콜라", 1);
        Order order = Order.of(orderMenu);

        Benefit benefit = new Benefit(date, order);
        benefit.applyGiveawayEvent();

        //when
        final String giveawayMenu = benefit.getGiveawayMenuByCase();

        //then
        assertThat(giveawayMenu).contains("샴페인 1개");
    }

    @Test
    void 티본스테이크1개와_바비큐립1개를_2일에_주문하면_총_5146원을_혜택받는다() {
        //given
        Date date = new Date(2);

        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("티본스테이크", 1);
        orderMenu.put("바비큐립", 1);
        Order order = Order.of(orderMenu);

        Benefit benefit = new Benefit(date, order);
        benefit.applyChristmasDDaySale();
        benefit.applyWeekdaysSale();
        benefit.applyWeekendSale();
        benefit.applySpecialSale();
        benefit.applyGiveawayEvent();

        //when
        final int totalBenefitAmount = benefit.totalBenefitAmount();

        //then
        assertThat(totalBenefitAmount).isEqualTo(5146);
    }
}
