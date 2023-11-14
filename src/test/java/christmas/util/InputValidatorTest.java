package christmas.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    void 날짜입력이_공백이거나_비어있으면_예외가_발생하여_false를_반환한다() {
        //given
        String input = "";

        //when
        final boolean exception = InputValidator.verifyVisitDate(input);

        //then
        assertThat(exception).isFalse();
    }

    @Test
    void 날짜입력에_문자가_포함되면_예외가_발생하여_false를_반환한다() {
        //given
        String input = "char";

        //when
        final boolean exception = InputValidator.verifyVisitDate(input);

        //then
        assertThat(exception).isFalse();
    }

    @Test
    void 날짜_범위를_벗어난_날짜입력이라면_예외가_발생하여_false를_반환한다() {
        //given
        String input = "32";

        //when
        final boolean exception = InputValidator.verifyVisitDate(input);

        //then
        assertThat(exception).isFalse();
    }

    @Test
    void 메뉴입력이_예시와_다른_형식이라면_예외가_발생하여_false를_반환한다() {
        //given
        String input = "티본스테이크:1,바비큐립:1";

        //when
        final boolean exception = InputValidator.verifyOrderMenu(input);

        //then
        assertThat(exception).isFalse();
    }
}
