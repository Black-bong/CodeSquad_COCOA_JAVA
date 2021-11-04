package algorithm.boj;

import java.util.Scanner;

public class Boj2442 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int j = 0;
        int k = 0;
        int starCount = scan.nextInt();

        for (i=1;i<=starCount;i++) {
            for (j=starCount;j>i;j--) {
                System.out.print(" ");
            }
            for (k=0;k<2*i-1;k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
