package algorithm;

import java.util.Scanner;

public class Boj_2444 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int temp = 5;
        int q = 1;
        int starCount = scan.nextInt();

        for (int i=1;i<=2 * starCount -1;i++) {
            if (i <= starCount) {
                for (int j=starCount;j>i;j--) {
                    System.out.print(" ");
                }
                for (int z=0;z<2*i-1;z++) {
                    System.out.print("*");
                }
            }
            if (i > starCount) {
                for (int x=0;x<q;x++) {
                    System.out.print(" ");
                }
                for (int y=0;y<2 * i - temp;y++) {
                    System.out.print("*");
                }
                q++;
                temp += 4;
            }
            System.out.println();
        }
    }
}
