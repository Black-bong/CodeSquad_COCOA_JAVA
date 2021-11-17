package shell;

import shell.view.ShellMain;

import java.io.IOException;

public class Shell {
    public void Start() throws IOException {
        ShellMain shellMain = new ShellMain();
        shellMain.shellMainScreen();
    }
}