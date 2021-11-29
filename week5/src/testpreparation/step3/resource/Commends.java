package testpreparation.step3.resource;

public enum Commends {
    MOVING_TO_RIGHT_TOP_LINE("U'", 0),
    MOVING_TO_LEFT_TOP_LINE("U", 1),
    MOVING_TO_DOWN_RIGHT_LINE("R'", 2),
    MOVING_TO_UP_RIGHT_LINE("R", 3),
    MOVING_TO_UP_LEFT_LINE("L'", 4),
    MOVING_TO_DOWN_LEFT_LINE("L", 5),
    MOVING_TO_RIGHT_BOTTOM_LINE("D", 6),
    MOVING_TO_LEFT_BOTTOM_LINE("D'", 7),
    MOVING_TO_RIGHT_FRONT("F", 8),
    MOVING_TO_LEFT_FRONT("F'", 9),
    MOVING_TO_RIGHT_BACK("B'", 10),
    MOVING_TO_LEFT_BACK("B", 11),
    CUBE_EXIT("Q", 12);

    private final String commend;
    private final int commendID;

    Commends(String commend, int commendID) {
        this.commend = commend;
        this.commendID = commendID;
    }

    public boolean isSameCommend(String commend) {
        return this.commend.equals(commend);
    }

    public static int transferCommendID(String commend) {
        for (var c : Commends.values()) {
            if (c.isSameCommend(commend)) {
                return c.commendID;
            }
        }
        throw new IllegalArgumentException();
    }
}
