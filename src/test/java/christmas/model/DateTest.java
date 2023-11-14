package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    void 날짜가_1일부터_31일_사이에_포함되지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Date(32))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 날짜가_21일_이라면_추가_2000원_할인_금액을_반환한다() {
        //given
        int day = 21;
        Date date = new Date(day);

        //when
        final int christmasBenefit = date.getChristmasBenefit();

        //then
        assertThat(christmasBenefit).isEqualTo(2000);
    }
}
