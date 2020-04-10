package domain;

public enum Operation {
    ORDER(1),
    PAYMENT(2),
    END(3);

    private final int operation;

    Operation(int operation) {
        this.operation = operation;
    }

    public static boolean isOrder(int operation) {
        return operation == ORDER.getOperation();
    }

    public static boolean isPayment(int operation) {
        return operation == PAYMENT.getOperation();
    }

    public static boolean isEnd(int operation) {
        return operation == END.getOperation();
    }

    public int getOperation() {
        return operation;
    }
}
