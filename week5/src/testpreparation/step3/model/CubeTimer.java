package testpreparation.step3.model;


import java.util.Timer;
import java.util.TimerTask;

public class CubeTimer {

    private static final CubeTimer instance = new CubeTimer();
    private int time = 0;
    private boolean timerFlag = true;

    public void timeCheck() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                playTime(timer);
            }
        };
        timer.schedule(timerTask, 0, 1000);
    }

    private void playTime(Timer timer) {
        if (timerFlag) {
            time++;
        }
        if (!timerFlag) {
            timer.cancel();
        }
    }

    public static CubeTimer getInstance() {
        return instance;
    }

    public int stopTimer() {
        timerFlag = false;
        return time;
    }
}