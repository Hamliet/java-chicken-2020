package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdersTest {
    @Test
    @DisplayName("getOrder 테스트")
    void getOrder() {
        Orders orders = new Orders(OrderFactory.create());
        assertThat(orders.getOrder(1)).isInstanceOf(Order.class);
    }

    @Test
    @DisplayName("orderUpdate 테스트")
    void orderUpdate() {
        Orders orders = new Orders(OrderFactory.create());
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        orders.orderUpdate(1, menu, 3);
        assertThat(orders.getOrder(1).isOrderExist()).isTrue();
    }
}
