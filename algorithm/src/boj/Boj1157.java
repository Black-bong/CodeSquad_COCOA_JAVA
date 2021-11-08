package boj;
import java.util.Scanner;

public class Boj1157 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int[] alphabet = new int[26];
        int index = 0;
        int max = 0;
        boolean flag = false;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 91) {
                alphabet[input.charAt(i) - 65]++;
            }
            if (input.charAt(i) > 96) {
                alphabet[input.charAt(i) - 97]++;
            }
        }

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == max) {
                flag = true;
            }
            if (alphabet[i] > max) {
                max = alphabet[i];
                index = i;
                flag = false;
            }
        }

        if (!flag) {
            System.out.println((char) (65 + index));
        }
        if (flag) {
            System.out.println("?");
        }
    }
}