package shell;

import shell.view.ShellMain;

import java.io.IOException;

public class Shell implements Runnable {
    public void Start() throws IOException {
        ShellMain shellMain = new ShellMain();
        shellMain.shellMainScreen();
    }

    @Override
    public void run() {
        try {
            Start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}