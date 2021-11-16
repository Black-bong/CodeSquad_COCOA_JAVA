package hangulclock;

import hangulclock.resource.HourHangul;
import hangulclock.resource.MinuteHangul;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\033[1;31m";

    public void clockStart() {
        String[][] clock =
                {{"한", "두", "세", "네", "다", "섯"},
                        {"여", "섯", "일", "곱", "여", "덟"},
                        {"아", "홉", "열", "한", "두", "시"},
                        {"자", "이", "삼", "사", "오", "십"},
                        {"정", "일", "이", "삼", "사", "육"},
                        {"오", "오", "칠", "팔", "구", "분"}};

        HourHangul[] hourHangul = HourHangul.values();
        MinuteHangul[] minuteHangul = MinuteHangul.values();
        timer(clock, hourHangul, minuteHangul);
    }

    private void timer(String[][] clock, HourHangul[] hourHangul, MinuteHangul[] minuteHangul) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                String time = LocalTime.now().toString();
                String hour = time.split(":")[0];
                String minute = time.split(":")[1];
                String seconds = time.split(":")[2];
                int hourValue = Integer.parseInt(hour) % 12;
                int minuteValue = Integer.parseInt(minute);
                createHour(clock, hourValue, hourHangul);
                createMinute(clock, minuteValue, minuteHangul);
                midnight(clock, hour);
                printClock(clock);
            }
        };
        timer.schedule(timerTask, 0, 5000);
    }

    private void createHour(String[][] clock, int hourValue, HourHangul[] hourHangul) {
        clock[2][5] = ANSI_RED + "시" + ANSI_RESET;
        for (HourHangul hangul : hourHangul) {
            if (hourValue == hangul.getHour()) {
                clock[hangul.getFirstIndex()][hangul.getLastIndex()] = ANSI_RED + hangul.getHangul() + ANSI_RESET;
            }
        }
    }

    private void createMinute(String[][] clock, int minuteValue, MinuteHangul[] minuteHangul) {
        if (minuteValue != 0) {
            clock[5][5] = ANSI_RED + "분" + ANSI_RESET;
        }
        int digit1 = minuteValue % 10;
        int digit10 = minuteValue - digit1;
        for (MinuteHangul hangul : minuteHangul) {
            if (minuteValue > 10) {
                clock[3][5] = ANSI_RED + "십" + ANSI_RESET;
                if (digit10 == hangul.getMinute()) {
                    clock[hangul.getFirstIndex()][hangul.getLastIndex()] = ANSI_RED + hangul.getHangul() + ANSI_RESET;
                }
                if (digit1 == hangul.getMinute()) {
                    clock[hangul.getFirstIndex()][hangul.getLastIndex()] = ANSI_RED + hangul.getHangul() + ANSI_RESET;
                }
            }
            if (minuteValue < 10) {
                if (digit1 == hangul.getMinute()) {
                    clock[hangul.getFirstIndex()][hangul.getLastIndex()] = ANSI_RED + hangul.getHangul() + ANSI_RESET;
                }
            }
        }
    }

    private void printClock(String[][] clock) {
        for (String[] chars : clock) {
            for (String aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private void midnight(String[][] clock, String hour) {
        if (Integer.parseInt(hour) == 12) {
            clock[4][0] = ANSI_RED + "정" + ANSI_RESET;
            clock[5][0] = ANSI_RED + "오" + ANSI_RESET;
        }
        if (Integer.parseInt(hour) == 24) {
            clock[3][0] = ANSI_RED + "자" + ANSI_RESET;
            clock[4][0] = ANSI_RED + "정" + ANSI_RESET;
        }
    }
}