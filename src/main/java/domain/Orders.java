package domain;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Orders {
    private static final List<Order> orders = new ArrayList<>();

    static {
        orders.add(new Order(1, new HashMap<Menu, Integer>()));
        orders.add(new Order(2, new HashMap<Menu, Integer>()));
        orders.add(new Order(3, new HashMap<Menu, Integer>()));
        orders.add(new Order(5, new HashMap<Menu, Integer>()));
        orders.add(new Order(6, new HashMap<Menu, Integer>()));
        orders.add(new Order(8, new HashMap<Menu, Integer>()));
    }

    public static void orderUpdate(int tableNumber, Menu menu, int orderCount) {
        Order order = orders.stream()
                .filter(o -> o.getTableNumber() == tableNumber)
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 Table 번호입니다."));
        order.addOrder(menu, orderCount);
    }

    public static Order getOrder(int tableNumber) {
        return orders.stream()
                .filter(o -> o.getTableNumber() == tableNumber)
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 Table 번호입니다."));
    }
}
