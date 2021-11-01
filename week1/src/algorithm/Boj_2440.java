package algorithm;

import java.util.Scanner;

public class Boj_2440 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int starCount = scan.nextInt();

        for (int i=1;i<=starCount;i++) {
            for (int j=starCount;j>=i;j--) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
    }
}
