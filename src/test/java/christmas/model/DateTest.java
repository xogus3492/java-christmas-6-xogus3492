package christmas.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DateTest {

    @Test
    void 날짜가_1일부터_31일_사이에_포함되지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Date(32))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
