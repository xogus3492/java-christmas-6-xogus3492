package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class MenuTest {

    @Test
    void 메뉴이름을_파라미터로_넘겨주면_이름과_일치하는_메뉴를_반환한다() {
        //given
        String name = "양송이수프";

        //when
        final Menu menu = Menu.getMenu(name);

        //then
        assertThat(menu).isEqualTo(Menu.BUTTON_MUSHROOM_SOUP);
    }
}
