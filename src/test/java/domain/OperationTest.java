package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Operation.ORDER;
import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {
    @Test
    @DisplayName("getOperation 테스트")
    void getOperation(){
        assertThat(ORDER.getOperation()).isEqualTo(1);
    }

    @Test
    @DisplayName("isOrder 테스트")
    void isOrder(){
        assertThat(Operation.isOrder(1)).isTrue();
    }

    @Test
    @DisplayName("isPayment 테스트")
    void isPayment(){
        assertThat(Operation.isPayment(2)).isTrue();
    }

    @Test
    @DisplayName("isEnd 테스트")
    void isEnd(){
        assertThat(Operation.isEnd(3)).isTrue();
    }
}
