package simplerpg.domain;


public class Monster implements Location {
    private int locationX;
    private int locationY;

    public Monster() {

    }

    @Override
    public void startLocate(int x, int y) {
        this.locationX = (int) (Math.random() * 5);
        this.locationY = (int) (Math.random() * 5);
        if (locationX == x && locationY == y) {
            System.out.println("다시");
            startLocate(x, y);
        }
    }

    public int sameLocate(int x) {
        return Integer.compare(x, locationX);
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }
}