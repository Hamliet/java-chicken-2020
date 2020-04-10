package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {
    @Test
    @DisplayName("생성 테스트")
    void create() {
        assertThat(new Menu(1, "후라이드", Category.CHICKEN, 16_000)).isInstanceOf(Menu.class);
    }

    @Test
    @DisplayName("getNumber 테스트")
    void getNumber() {
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        assertThat(menu.getNumber()).isEqualTo(1);
    }
}
