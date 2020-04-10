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
            validate(beforeCount + orderCount);
            orderedMenu.put(menu, beforeCount + orderCount);
            return;
        }
        validate(orderCount);
        orderedMenu.put(menu, orderCount);
    }

    private void validate(int count) {
        if (count > 99) {
            throw new IllegalArgumentException("주문 수량이 99개 이상입니다.");
        }
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
        double price = getPrice();
        double discount = getDiscount();
        double totalPayment = price - discount;

        if (inputHowToPay == CASH) {
            totalPayment *= 0.95;
        }
        return totalPayment;
    }

    private double getPrice() {
        double sum = 0;
        Set<Map.Entry<Menu, Integer>> entries = orderedMenu.entrySet();

        for (Map.Entry<Menu, Integer> entry : entries) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    private double getDiscount() {
        double count = 0;
        Set<Map.Entry<Menu, Integer>> entries = orderedMenu.entrySet();

        for (Map.Entry<Menu, Integer> entry : entries) {
            count += getCountIfChicken(entry);
        }
        return (count / 10) * 10000;
    }

    private double getCountIfChicken(Map.Entry<Menu, Integer> entry) {
        if (entry.getKey().getCategory() == Category.CHICKEN) {
            return entry.getValue();
        }
        return 0;
    }

    public void clearOrderedMenu() {
        this.orderedMenu = new HashMap<>();
    }
}
