import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Orders orders = new Orders(OrderFactory.create());

        while (true) {
            int operation = InputView.inputMainOperation();
            if (Operation.isEnd(operation)) {
                break;
            }
            if (Operation.isOrder(operation)) {
                order(orders);
            }
            if (Operation.isPayment(operation)) {
                payment(orders);
            }
        }
    }

    private static void order(Orders orders) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(orders, tables);

        final int tableNumber = InputView.inputTableNumber();
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputMenu();
        final int menuCount = InputView.inputMenuCount();
        try {
            orders.orderUpdate(tableNumber, MenuRepository.getMenu(menuNumber), menuCount);
        } catch (IllegalArgumentException error) {
            OutputView.printError(error);
        }
    }

    private static void payment(Orders orders) {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(orders, tables);

        final int tableNumber = InputView.inputTableNumber();
        OutputView.printOrder(orders, tableNumber);

        Order order = orders.getOrder(tableNumber);
        final double totalPayment = order.getTotalPayment(InputView.inputHowToPay(tableNumber));
        OutputView.totalAmountToPay(totalPayment);
        order.clearOrderedMenu();
    }
}
