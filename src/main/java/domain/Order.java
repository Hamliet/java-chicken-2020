package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Order {
    private static final int CASH = 2;
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

    public double getTotalPayment(int inputHowToPay) {
        double chickenPayment = getPrice(Category.CHICKEN);
        double beveragePayment = getPrice(Category.BEVERAGE);
        double totalPayment = chickenPayment + beveragePayment;

        if (inputHowToPay == CASH) {
            totalPayment *= 0.95;
        }
        return totalPayment;
    }

    private double getPrice(Category category) {
        double sum = 0;
        double count = 0;
        Set<Map.Entry<Menu, Integer>> entries = orderedMenu.entrySet();

        for (Map.Entry<Menu, Integer> entry : entries) {
            sum += entry.getKey().getPrice() * entry.getValue();
            count++;
        }
        if (category == Category.CHICKEN && count >= 10) {
            sum -= (count / 10) * 10000;
        }
        return sum;
    }
}
