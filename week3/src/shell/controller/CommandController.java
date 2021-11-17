package shell.controller;

import shell.model.CommandProgress;

import java.io.IOException;

public class CommandController {
    public void selectCommand(int id) throws IOException {
        //TODO 스위치를 사용안하고 입력된 명령어를 구분할 수 있는 방법을 찾아보자.
        CommandProgress commandProgress = new CommandProgress();
        switch (id) {
            case 0:
            commandProgress.pwd();
            break;
            case 1:
            commandProgress.mkdir();
            break;
            case 2:
            commandProgress.rm();
            break;
            case 3:
            commandProgress.cd();
            break;
            case 4:
            commandProgress.ls();
            break;
            //TODO case 5: 한글시계 보이는 명령어 추가
            case 5:
            break;
            case 6:
            System.exit(0);
        }
    }
}