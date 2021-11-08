package boj;

import java.util.Scanner;

public class Boj2884 {

    public static final int MINUS_MIN = 45;
    public static final int ONE_HOUR = 60;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hour = scan.nextInt();
        int min = scan.nextInt();

        calculateForTime(hour, min);
    }

    static void calculateForTime(int hour, int min) {
        int resultHour = 0;
        int resultMin = 0;

        resultMin = min - MINUS_MIN;

        if (resultMin < 0) {
            hour--;
            if (hour < 0) {
                hour = 23;
            }
            resultMin = ONE_HOUR - Math.abs(resultMin);
        }
        resultHour = hour;
        System.out.println(resultHour + " " + resultMin);
    }
}

