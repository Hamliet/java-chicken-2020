package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderFactory {
    private OrderFactory() {
    }

    public static List<Order> create() {
        List<Table> tables = TableRepository.tables();
        List<Order> orders = new ArrayList<>();

        for (Table table : tables) {
            orders.add(new Order(table, new HashMap<Menu, Integer>()));
        }
        return orders;
    }
}
