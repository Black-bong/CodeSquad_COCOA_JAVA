package algorithm.boj;

import java.util.Scanner;

public class Boj2445 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int starCount = scan.nextInt();
        int row = 2 * starCount -1;
        int column = 2 * starCount;
        int point = column / 2;
        int start = 0;
        int end = 0;

        char[][] star = new char[row][column];

        for (int i = 0; i < column; i++) {

            if (i >= point) {
                for (;start < row + end; start--) {
                    star[start][i] = '*';
                    end --;
                }
            } else {
                for (;start < row - end; start++) {
                    star[start][i] = '*';
                    end ++;
                }
            }
        }
    }
}
