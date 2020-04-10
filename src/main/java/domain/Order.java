package domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int tableNumber;
    private Map<Menu, Integer> orderedMenu;

    public Order(int tableNumber, HashMap<Menu, Integer> orderedMenu) {
        this.tableNumber = tableNumber;
        this.orderedMenu = orderedMenu;
    }

    public void addOrder(Menu menu, int orderCount) {
        if (orderedMenu.containsKey(menu)) {
            int beforeCount = orderedMenu.get(menu);
            orderedMenu.put(menu, beforeCount + orderCount);
            return;
        }
        orderedMenu.put(menu, orderCount);
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public Map<Menu, Integer> getOrderedMenu() {
        return orderedMenu;
    }

    public boolean isOrderExist() {
        return orderedMenu.size() > 0;
    }
}
