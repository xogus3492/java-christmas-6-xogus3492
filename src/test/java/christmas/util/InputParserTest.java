package christmas.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    void 입력받은_메뉴를_파라미터로_넘기면_각각_메뉴이름과_갯수를_Map_객체로_파싱한다() {
        //given
        String input = "티본스테이크-2,초코케이크-1";

        //when
        final Map<String, Integer> orderMenu = InputParser.parseMap(input);

        //then
        assertThat(orderMenu).hasSize(2)
                .contains(entry("티본스테이크", 2), entry("초코케이크", 1));
    }
}
