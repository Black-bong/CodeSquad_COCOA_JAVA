package moneybook.resources;

public enum MonthList {
    JANUARY("01월"),
    FEBRUARY("02월"),
    MARCH("03월"),
    APRIL("04월"),
    MAY("05월"),
    JUNE("06월"),
    JULY("07월"),
    AUGUST("08월"),
    SEPTEMBER("09월"),
    OCTOBER("10월"),
    NOVEMBER("11월"),
    DECEMBER("12월");

    private final String month;

    MonthList(String month) {
        this.month = month;
    }

    public boolean isSameMonth(String month) {
        return this.month.equals(month);
    }

    public static MonthList getMatchMonth(String month) {
        for (MonthList m : MonthList.values()) {
            if (m.isSameMonth(month)) {
                return m;
            }
        }
        throw new IllegalArgumentException();
    }
}
