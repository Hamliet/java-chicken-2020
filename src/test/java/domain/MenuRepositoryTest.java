package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuRepositoryTest {
    @Test
    @DisplayName("getMenu 테스트")
    void getMenu(){
        final List<Menu> menus = MenuRepository.menus();
        assertThat(MenuRepository.getMenu(1)).isInstanceOf(Menu.class);
    }
}
