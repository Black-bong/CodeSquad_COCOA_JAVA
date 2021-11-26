package testpreparation.step2.domain;


public class Cube {
    private final String[][] cube;

    public Cube(String[][] cube) {
        this.cube = cube;
    }

    public String[][] getCube() {
        return cube;
    }

    public int getCubeSize() {
        return cube.length;
    }

    public void replaceCube(int index, String[] values) {
        cube[index] = values;
    }

    public void printCube() {
        for (String[] strings : cube) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
        System.out.println();
    }

}
