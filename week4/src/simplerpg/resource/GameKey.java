package simplerpg.resource;

public enum GameKey {
    UP("W", -1, 0),
    LEFT("A", 0, -1),
    RIGHT("D", 0, 1),
    DOWN("S", 1, 0);

    private final String inputKey;
    private final int locationX;
    private final int locationY;
    private static int[] keyIndex = new int[2];

    GameKey(String inputKey, int locationX, int locationY) {
        this.inputKey = inputKey;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public boolean isSameKey(String key) {
        return getInputKey().equals(key);
    }

    public String getInputKey() {
        return inputKey;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public static int[] gameKeyList(String key) {
        for (var k : GameKey.values()) {
            if (k.isSameKey(key)) {
                keyIndex[0] = k.getLocationX();
                keyIndex[1] = k.getLocationY();
                return keyIndex;
            }
        }
        throw new IllegalArgumentException();
    }
}
