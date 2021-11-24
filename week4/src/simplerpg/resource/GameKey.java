package simplerpg.resource;

public enum GameKey {
    UP("W", 0, 1),
    LEFT("A", -1, 0),
    RIGHT("D", 1, 0),
    DOWN("S", 0 , -1);
    
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
