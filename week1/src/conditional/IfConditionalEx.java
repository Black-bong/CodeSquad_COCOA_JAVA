package conditional;

import java.util.Scanner;

public class IfConditionalEx {

    public static final int MINUS_MIN = 45;
    public static final int ONE_HOUR = 60;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hour = scan.nextInt();
        int min = scan.nextInt();

        calculateForTime(hour, min);
    }

    static void calculateForTime(int hour, int min) {
        min = min - MINUS_MIN;

        if (min < 0) {
            min = calculateForMin(min);
            hour = calculateForHour(hour);
        }
        System.out.println(hour + " " + min);
    }

    static int calculateForHour(int h) {
        h--;

        if (h < 0) {
            return 23;
        }
        return h;
    }

    static int calculateForMin(int m) {

        return ONE_HOUR - Math.abs(m);
    }
}
