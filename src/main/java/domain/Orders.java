package domain;

import java.util.List;

public class Orders {
    private final List<Order> orders;

    public Orders(List<Order> orders) {
        this.orders = orders;
    }

    public void orderUpdate(int tableNumber, Menu menu, int orderCount) {
        Order order = orders.stream()
                .filter(o -> o.getTableNumber() == tableNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("!! 실패 : 존재하지 않는 Table 번호입니다."));
        order.addOrder(menu, orderCount);
    }

    public Order getOrder(int tableNumber) {
        return orders.stream()
                .filter(o -> o.getTableNumber() == tableNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("!! 실패 : 존재하지 않는 Table 번호입니다."));
    }
}
