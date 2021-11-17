package shell.model;

import shell.view.ShellMain;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class CommandProgress {
    private static final Logger LOG = Logger.getGlobal();
    private File directory = new File(System.getProperty("user.dir")).getAbsoluteFile();
    ShellMain shellMain = new ShellMain();

    //TODO 디렉토리가 아니라 파일이 생성된다.. 좀더 알아보자
    public void mkdir(String c) throws IOException {
        LOG.info("mkdir 명령어");
        PrintWriter output = null;
        output = new PrintWriter(new File(c).getAbsoluteFile());
        shellMain.shellMainScreen();
    }

    public void ls() throws IOException {
        LOG.info("ls 명령어");
        shellMain.shellMainScreen();
    }

    public void cd(String c) throws IOException {
        LOG.info("cd 명령어");
        shellMain.shellMainScreen();
    }

    public void rm(String c) throws IOException {
        LOG.info("rm 명령어");
        shellMain.shellMainScreen();
    }

    public void pwd() throws IOException {
        LOG.info("pwd 명령어");
        System.out.println(directory);
        shellMain.shellMainScreen();
    }
}