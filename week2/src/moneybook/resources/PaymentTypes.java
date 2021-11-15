package moneybook.resources;

public enum PaymentTypes {
    NOT_EXPENSES("없음"),
    CASH("카드"),
    CARD("현금");

    private final String value;

    PaymentTypes(String value) {
        this.value = value;
    }

    public boolean isSamePaymentType(String value) {
        return this.value.equals(value);
    }

    public static PaymentTypes getMatchedPaymentType(String value) {
        for (PaymentTypes type : PaymentTypes.values()) {
            if (type.isSamePaymentType(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException();
    }
}
