package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhileLoopEx {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int firstNumber = Integer.parseInt(buf.readLine());
        System.out.println(cycle(firstNumber));
    }

    private static int cycle(int number) {
        int cycleCount = 0;
        int temp = number;

        while (true) {
            cycleCount++;
            int value = separationOfNumbers(number);
            if (temp == value) {
                return cycleCount;
            }
            number = value;
        }
    }

    private static int separationOfNumbers(int n) {
        int value = (n / 10) + (n % 10);
        return (n % 10 * 10) + (value % 10);
    }
}
