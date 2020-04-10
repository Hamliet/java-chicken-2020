package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdersTest {
    @Test
    @DisplayName("getOrder 테스트")
    void getOrder() {
        assertThat(Orders.getOrder(1)).isInstanceOf(Order.class);
    }
}
