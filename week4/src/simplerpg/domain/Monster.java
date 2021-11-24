package simplerpg.domain;

public class Monster implements Location{
    private int locationX;
    private int locationY;

    public Monster() {
        startLocate();
    }

    @Override
    public void startLocate() {
        this.locationX = (int)(Math.random()*5);
        this.locationY = (int)(Math.random()*5);
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }
}
