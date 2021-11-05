package algorithm.boj;

import java.io.IOException;
import java.util.Scanner;

public class Boj2908 {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();

        a = transferDigit(a);
        b = transferDigit(b);

        System.out.println(Math.max(a, b));
    }

    public static int transferDigit(int t) {
        int digit1 = t / 100;
        int digit10 = t % 100 - t % 10;
        int digit100 = (t % 10) * 100;

        return digit100 + digit10 + digit1;
    }
}