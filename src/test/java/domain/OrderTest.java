package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {
    @Test
    @DisplayName("생성 테스트")
    void create() {
        assertThat(new Order(new Table(1), new HashMap<>())).isInstanceOf(Order.class);
    }

    @Test
    @DisplayName("getTableNumber 테스트")
    void getTableNumber() {
        Order order = new Order(new Table(1), new HashMap<>());
        assertThat(order.getTableNumber()).isEqualTo(1);
    }

    @Test
    @DisplayName("getOrderedMenu 테스트")
    void getOrderedMenu() {
        Order order = new Order(new Table(1), new HashMap<>());
        assertThat(order.getOrderedMenu()).isInstanceOf(Map.class);
    }

    @Test
    @DisplayName("addOrder 테스트")
    void addOrder() {
        Order order = new Order(new Table(1), new HashMap<>());
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        order.addOrder(menu, 2);
        order.addOrder(menu, 1);
        assertThat(order.getOrderedMenu().get(menu)).isEqualTo(3);
    }

    @Test
    @DisplayName("isOrderExist 테스트")
    void isOrderExist() {
        Order order = new Order(new Table(1), new HashMap<>());
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        order.addOrder(menu, 2);
        order.addOrder(menu, 1);
        assertThat(order.isOrderExist()).isTrue();
    }

    @Test
    @DisplayName("getTotalPayment 테스트")
    void getTotalPayment() {
        Order order = new Order(new Table(1), new HashMap<>());
        Menu chicken = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        Menu beverage = new Menu(2, "음료", Category.CHICKEN, 5_000);
        order.addOrder(chicken, 1);
        order.addOrder(beverage, 2);
        assertThat(order.getTotalPayment(1)).isEqualTo(26000);
    }

    @Test
    @DisplayName("clearOrderedMenu 테스트")
    void clearOrderedMenu() {
        Order order = new Order(new Table(1), new HashMap<>());
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        order.addOrder(menu, 1);
        order.addOrder(menu, 2);
        order.clearOrderedMenu();
        assertThat(order.isOrderExist()).isFalse();
    }
}
