package shell.controller;

import hangulclock.Clock;
import shell.model.CommandProgress;

import java.io.IOException;

public class CommandController {
    public void selectCommand(int id, String firstComm, String secondComm) throws IOException {
        //TODO 스위치를 사용안하고 입력된 명령어를 구분할 수 있는 방법을 찾아보자.
        CommandProgress commandProgress = new CommandProgress();
        Clock clock = new Clock();
        switch (id) {
            case 0:
                commandProgress.pwd();
                break;
            case 1:
                commandProgress.mkdir(firstComm);
                break;
            case 2:
                commandProgress.rm(firstComm);
                break;
            case 3:
                commandProgress.cd(firstComm);
                break;
            case 4:
                commandProgress.ls();
                break;
            case 5:
                clock.clockStart();
                break;
            case 6:
                System.exit(0);
                break;
            case 7:
                commandProgress.cp(firstComm, secondComm);
                break;
            case 8:
                commandProgress.touch(firstComm);
                break;
        }
    }
}