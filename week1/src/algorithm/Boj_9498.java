package algorithm;

import java.util.Scanner;

public class Boj_9498 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int score = scan.nextInt() / 10;

        switch (score) {
            case 10, 9 -> System.out.println("A");
            case 8 -> System.out.println("B");
            case 7 -> System.out.println("C");
            case 6 -> System.out.println("D");
            default -> System.out.println("F");
        }
    }
}
