package christmas.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumberFormatterTest {

    @Test
    void 숫자를_파라미터로_넘기면_구분자가_적용된_형식으로_변환() {
        //given
        int number = 142000;

        //when
        final String count = NumberFormatter.formulateNumber(number);

        //then
        assertThat(count).isEqualTo("142,000");
    }
}
