package domain;

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

    public static Order getOrder(int tableNumber) {
        return orders.stream()
                .filter(o -> o.getTableNumber() == tableNumber)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static void orderUpdate(int tableNumber, Menu menu, int orderCount) {
        Order order = orders.stream()
                .filter(o -> o.getTableNumber() == tableNumber)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        order.addOrder(menu, orderCount);
    }
}
