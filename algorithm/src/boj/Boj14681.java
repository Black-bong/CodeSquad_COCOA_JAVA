package boj;

import java.util.Scanner;

public class Boj14681 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int xPoint = scan.nextInt();
        int yPoint = scan.nextInt();

        if (xPoint > 0 && yPoint > 0) {
            System.out.println("1");
        }
        if (xPoint > 0 && yPoint < 0) {
            System.out.println("4");
        }
        if (xPoint < 0 && yPoint > 0) {
            System.out.println("2");
        }
        if (xPoint < 0 && yPoint < 0) {
            System.out.println("3");
        }
    }
}
