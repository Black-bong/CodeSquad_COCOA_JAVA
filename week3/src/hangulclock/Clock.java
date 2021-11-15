package hangulclock;

import hangulclock.resource.HourHangul;
import hangulclock.resource.MinuteHangul;

import java.time.LocalTime;
import java.util.Arrays;

public class Clock {

    public void clockStart() {
        char[][] clock = new char[6][6];

        HourHangul[] hourHangul = HourHangul.values();
        MinuteHangul[] minuteHangul = MinuteHangul.values();

        String time = LocalTime.now().toString();
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];
        int hourIndex = Integer.parseInt(hour) % 12;
        int minuteIndex = Integer.parseInt(minute);

        resetClock(clock);
        createHour(clock, hourIndex, hourHangul);
        createMinute(clock, minuteIndex, minuteHangul);
        midnight(clock, hour);
        printClock(clock);
    }

    private void createHour(char[][] clock, int hourIndex, HourHangul[] hourHangul) {
        clock[2][5] = '시';
        for (HourHangul hangul : hourHangul) {
            if (hourIndex == hangul.getHour()) {
                clock[hangul.getFirstIndex()][hangul.getLastIndex()] = hangul.getHangul();
            }
        }
    }

    private void createMinute(char[][] clock, int minuteIndex, MinuteHangul[] minuteHangul) {
        clock[5][5] = '분';
        int digit1 = minuteIndex % 10;
        int digit10 = minuteIndex - digit1;
        if (minuteIndex == 0) {
            clock[5][5] = ' ';
        }
        for (MinuteHangul hangul : minuteHangul) {
            if (minuteIndex > 10) {
                clock[3][5] = '십';
                if (digit10 == hangul.getMinute()) {
                    clock[hangul.getFirstIndex()][hangul.getLastIndex()] = hangul.getHangul();
                }
                if (digit1 == hangul.getMinute()) {
                    clock[hangul.getFirstIndex()][hangul.getLastIndex()] = hangul.getHangul();
                }
            }
            if (minuteIndex < 10) {
                if (digit1 == hangul.getMinute()) {
                    clock[hangul.getFirstIndex()][hangul.getLastIndex()] = hangul.getHangul();
                }
            }
        }
    }

    private void resetClock(char[][] clock) {
        for (char[] chars : clock) {
            Arrays.fill(chars, ' ');
        }
    }

    private void printClock(char[][] clock) {
        for (char[] chars : clock) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private void midnight(char[][] clock, String hour) {
        if (Integer.parseInt(hour) == 12) {
            resetClock(clock);
            clock[4][0] = '정';
            clock[5][0] = '오';
        }
        if (Integer.parseInt(hour) == 24) {
            resetClock(clock);
            clock[3][0] = '자';
            clock[4][0] = '정';
        }
    }
}