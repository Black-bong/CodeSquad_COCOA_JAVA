package moneybook.resources;

public enum DayList {
    FIRST("01일"),SECOND("02일"),THIRD("03일"),FOURTH("04일"),FIFTH("05일"),SIXTH("06일"),SEVENTH("07일"),
    EIGHTH("08일"),NINTH("09일"),TENTH("10일"),ELEVENTH("11일"),TWELFTH("12일"),THIRTEENTH("13일"),FOURTEENTH("14일"),
    FIFTEENTH("15일"),SIXTEENTH("16일"),SEVENTEENTH("17일"),EIGHTEENTH("18일"),NINETEEN("19일"),TWENTIETH("20일"),
    TWENTY_FIRST("21일"),TWENTY_SECOND("22일"),TWENTY_THIRD("23일"),TWENTY_FOURTH("24일"),TWENTY_FIFTH("25일"),
    TWENTY_SIXTH("26일"),TWENTY_SEVENTH("27일"),TWENTY_EIGHTH("28일"),TWENTY_NINTH("29일"),THIRTIETH("30일"),
    THIRTY_FIRST("31일");

    private final String day;

    DayList(String day) {
        this.day = day;
    }

    public boolean isSameDay(String day) {
        return this.day.equals(day);
    }

    public static DayList getDayList(String value) {
        for (DayList d : DayList.values()) {
            if (d.isSameDay(value)) {
                return d;
            }
        }
        throw new IllegalArgumentException();
    }
}
