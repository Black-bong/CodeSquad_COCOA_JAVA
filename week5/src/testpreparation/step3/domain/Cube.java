package testpreparation.step3.domain;

public class Cube {
    private String[][] cube;
    private int id;
    private final String color;
    private final int width;
    private final int length;

    public Cube(String color, int width, int length) {
        this.color = color;
        this.width = width;
        this.length = length;
        createCube();
    }

    private void createCube() {
        cube = new String[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                cube[i][j] = color;
            }
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[][] getCube() {
        return cube;
    }
}