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
}
