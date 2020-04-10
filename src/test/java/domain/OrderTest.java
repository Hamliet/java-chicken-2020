package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    @Test
    @DisplayName("생성 테스트")
    void create(){
        assertThat(new Order(1,new HashMap<>())).isInstanceOf(Order.class);
    }

    @Test
    @DisplayName("getTableNumber 테스트")
    void getTableNumber(){
        Order order = new Order(1, new HashMap<>());
        assertThat(order.getTableNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("addOrder 테스트")
    void addOrder(){
        Order order = new Order(1, new HashMap<>());
        Menu menu = new Menu(1,"후라이드",Category.CHICKEN,16_000);
        order.addOrder(menu,2);
        order.addOrder(menu,1);
        assertThat(order.getOrderedMenu().get(menu)).isEqualTo(3);
    }
}
