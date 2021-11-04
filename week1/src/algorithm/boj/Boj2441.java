package algorithm.boj;

import java.util.Scanner;

public class Boj2441 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int starCount = scan.nextInt();

        for (int i=1;i<=starCount;i++) {
            for (int j=2;j<=i;j++) {
                System.out.print(" ");
            }
            for (int k=starCount;k>=i;k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
