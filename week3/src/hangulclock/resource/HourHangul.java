package hangulclock.resource;


public enum HourHangul {
    HAN("한", 1, 0, 0),
    DOO("두", 2, 0, 1),
    SAE("세", 3, 0, 2),
    NE("네", 4, 0, 3),
    DA("다", 5, 0, 4),
    DA_SUT("섯", 5, 0, 5),
    YEO("여", 6, 1, 0),
    YEO_SUT("섯", 6, 1, 1),
    Il("일", 7, 1, 2),
    GOP("곱", 7, 1, 3),
    YEO_DEOL("여", 8, 1, 4),
    DEOL("덟", 8, 1, 5),
    A("아", 9, 2, 0),
    HOB("홉", 9, 2, 1),
    YEOL("열", 10, 2, 2),
    YEOL_HAN_SI("열", 11, 2, 2),
    YEOL_HAN("한", 11, 2, 3),
    YEOL_DO("두", 12, 2, 4);


    private final String hangul;
    private final int hour;
    private final int firstIndex;
    private final int lastIndex;

    HourHangul(String hangul, int hour, int firstIndex, int lastIndex) {
        this.hangul = hangul;
        this.hour = hour;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }

    public String getHangul() {
        return hangul;
    }

    public int getHour() {
        return hour;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getLastIndex() {
        return lastIndex;
    }
}