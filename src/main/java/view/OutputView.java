package view;

import domain.Menu;
import domain.Order;
import domain.Orders;
import domain.Table;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDERED_BOTTOM_LINE = "└ W ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    private static void printBottomLine(List<Table> tables) {
        for (int index = 0; index < tables.size(); index++) {
            String bottomLine = lineSelector(index, tables);
            System.out.print(bottomLine);
        }
        System.out.println();
    }

    private static String lineSelector(int index, List<Table> tables) {
        Order order = Orders.getOrder(tables.get(index).getNumber());
        if (order.isOrderExist()) {
            return ORDERED_BOTTOM_LINE;
        }
        return BOTTOM_LINE;
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrder(int tableNumber) {
        Order order = Orders.getOrder(tableNumber);
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");

        Map<Menu, Integer> orderedMenu = order.getOrderedMenu();
        printOrderedMenus(orderedMenu);

        System.out.println();
    }

    private static void printOrderedMenus(Map<Menu, Integer> orderedMenu) {
        Set<Map.Entry<Menu, Integer>> entries = orderedMenu.entrySet();

        for (Map.Entry<Menu, Integer> entry : entries) {
            System.out.printf("%s %s %s\n", entry.getKey().getName(), entry.getValue(), entry.getKey().getPrice() * entry.getValue());
        }
    }

    public static void totalAmountToPay(double totalPayment) {
        System.out.printf("## 최종 결제할 금액 %.0f%s\n\n",totalPayment, "원");
    }
}
