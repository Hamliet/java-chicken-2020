import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {


    public static void main(String[] args) {
        while (true) {
            int operation = InputView.inputMainOperation();
            if (Operation.isEnd(operation)) {
                break;
            }
            if (Operation.isOrder(operation)) {
                order();
            }
            if (Operation.isPayment(operation)) {
                payment();
            }
        }
    }

    private static void order() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputMenu();
        final int menuCount = InputView.inputMenuCount();
        Orders.orderUpdate(tableNumber, MenuRepository.getMenu(menuNumber), menuCount);
    }

    private static void payment() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        final int tableNumber = InputView.inputTableNumber();
    }
}
