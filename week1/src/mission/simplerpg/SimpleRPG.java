package mission.simplerpg;

public class SimpleRPG {
    public static void main(String[] args) {
        SimpleRPG smp = new SimpleRPG();
        String[][] field = new String[5][5];

        smp.screen(field);
        smp.printScreen(field);
    }

    public void moving(String m) {
        switch (m) {
            case "w": // 열 고정 행 -1
            case "s": // 열 고정 행 +1
            case "a": // 열 -1 행 고정
            case "d": // 열 +1 행 고정
        }
    }

    public void screen(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = "- ";
            }
        }
        field[2][2] = "C ";
    }

    public void printScreen(String[][] f) {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f[i].length; j++) {
                System.out.print(f[i][j]);
            }
            System.out.println();
        }
    }
}
