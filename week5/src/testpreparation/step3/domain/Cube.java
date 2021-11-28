package testpreparation.step3.domain;

public class Cube {
    private String[][] cube;
    private int id;
    private String color;
    private int width;
    private int length;

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

    public StringBuilder printCubeTB() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append("        ");
            for (int j = 0; j < width; j++) {
                sb.append(cube[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb;
    }

    public StringBuilder printCubeCenter() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(cube[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb;
    }

    public String[][] getCube() {
        return cube;
    }
}
