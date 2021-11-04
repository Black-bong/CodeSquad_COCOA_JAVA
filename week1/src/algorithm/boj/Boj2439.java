package algorithm.boj;

import java.util.Scanner;

public class Boj2439 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int starCount = scan.nextInt();

        for (int i=1;i<=starCount;i++) {
            for (int j=starCount;j>i;j--) {
                System.out.print(" ");
            }
            for (int k=0;k<i;k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
