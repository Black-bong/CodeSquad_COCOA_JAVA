package hangulclock.resource;

public enum MinuteHangul {
    Il("일", 1, 4, 1),
    YI_SIP("이", 20, 3, 1),
    YI("이", 2, 4, 2),
    SAM_SIP("삼", 30, 3, 2),
    SAM("삼", 3, 4, 3),
    SA_SIP("사", 40, 3, 3),
    SA("사", 4, 4, 4),
    OH_SIP("오", 50, 3, 4),
    OH("오", 5, 5, 1),
    YUK("육", 6, 4, 5),
    CHIL("칠", 7, 5, 2),
    PAL("팔", 8, 5, 3),
    GU("구", 9, 5, 4),
    SIP("십", 10, 3, 5);


    private final String hangul;
    private final int minute;
    private final int firstIndex;
    private final int lastIndex;

    MinuteHangul(String hangul, int minute, int firstIndex, int lastIndex) {
        this.hangul = hangul;
        this.minute = minute;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }

    public String getHangul() {
        return hangul;
    }

    public int getMinute() {
        return minute;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getLastIndex() {
        return lastIndex;
    }
}