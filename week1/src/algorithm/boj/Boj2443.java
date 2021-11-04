package algorithm.boj;

import java.util.Scanner;

public class Boj2443 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int temp = 1;

        int starCount = scan.nextInt();

        for (int i=1; i<=starCount; i++) {
            for (int j=1; j<i; j++) {
                System.out.print(" ");
            }
            for (int z=0; z<2 * starCount - temp ; z++) {
                System.out.print("*");
            }
            temp += 2;
            System.out.println();
        }
    }
}
