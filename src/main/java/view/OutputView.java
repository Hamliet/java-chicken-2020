package view;

import domain.Menu;
import domain.Order;
import domain.Orders;
import domain.Table;

import java.util.List;

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


}
