package loop;

import java.util.Scanner;

public class ForLoopEx {

    public static boolean flag = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int start = scan.nextInt();
        int end = scan.nextInt();

        gugudan(start, end);
    }

    static void gugudan(int start, int end) {
        for (int i=start;i<=end;i++) {
            for (int j=1;j<=9;j++ ) {
                if (j == 2) {
                    flag = false;
                    break;
                }
                System.out.println(i + "*" + j + "=" + i * j);
            }
            System.out.println("------------------");
            if (!flag) {
                break;
            }
        }
    }
}