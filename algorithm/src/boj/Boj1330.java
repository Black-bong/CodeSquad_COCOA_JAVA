package boj;

import java.util.Scanner;

public class Boj1330 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();

        if (a > b) {
            System.out.println(">");
        }
        if (a < b) {
            System.out.println("<");
        }
        if (a == b) {
            System.out.println("==");
        }
    }
}
