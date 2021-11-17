package shell.model;

import shell.view.ShellMain;

import java.io.IOException;
import java.util.logging.Logger;

public class CommandProgress {
    private static final Logger LOG = Logger.getGlobal();
    ShellMain shellMain = new ShellMain();

    public void mkdir() throws IOException {
        LOG.info("mkdir 명령어");
        shellMain.shellMainScreen();
    }

    public void ls() throws IOException {
        LOG.info("ls 명령어");
        shellMain.shellMainScreen();
    }

    public void cd() throws IOException {
        LOG.info("cd 명령어");
        shellMain.shellMainScreen();
    }

    public void rm() throws IOException {
        LOG.info("rm 명령어");
        shellMain.shellMainScreen();
    }

    public void pwd() throws IOException {
        LOG.info("pwd 명령어");
        String directoryName = System.getProperty("user.dir");
        System.out.println(directoryName);
        shellMain.shellMainScreen();
    }
}