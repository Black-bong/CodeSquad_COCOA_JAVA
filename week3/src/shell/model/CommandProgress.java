package shell.model;

import shell.view.ShellMain;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class CommandProgress {
    private static final Logger LOG = Logger.getGlobal();
    Path path;
    ShellMain shellMain = new ShellMain();

    public CommandProgress() {
        this.path = Paths.get("").toAbsolutePath();
    }

    //TODO 디렉토리가 아니라 파일이 생성된다.. 좀더 알아보자
    public void mkdir(String c) throws IOException {
        LOG.info("mkdir 명령어");
        Path newPath = Paths.get(path.toString(), c);
        try {
            Files.createDirectory(newPath);
        } catch (FileAlreadyExistsException e) {
            System.out.println("mkdir: " + c + ": File exists");
        } finally {
            shellMain.shellMainScreen();
        }
    }

    public void ls() throws IOException {
        LOG.info("ls 명령어");
        File ls = new File(path.toString());
        StringBuilder sb = new StringBuilder();

        String[] fileList = ls.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return !name.startsWith(".");
            }
        });
        assert fileList != null;
        for (var fileName : fileList) {
            sb.append(fileName).append(" ");
        }

        System.out.print(sb);
        System.out.println();
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
        System.out.println(path);
        shellMain.shellMainScreen();
    }
}