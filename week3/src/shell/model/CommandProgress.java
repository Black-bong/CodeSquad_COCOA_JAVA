package shell.model;

import shell.view.ShellMain;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;

public class CommandProgress {
    private final Path path;
    ShellMain shellMain = new ShellMain();

    public CommandProgress() {
        this.path = Paths.get("").toAbsolutePath();
    }

    public void mkdir(String firstComm) throws IOException {
        Path newPath = Paths.get(path.toString(), firstComm);
        try {
            Files.createDirectory(newPath);
        } catch (FileAlreadyExistsException e) {
            System.out.println("mkdir: " + firstComm + ": File exists");
        } finally {
            shellMain.shellMainScreen();
        }
    }

    public void ls() throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(path.toString());
        String[] fileList = file.list(new FilenameFilter() {
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

    public void cd(String firstComm) throws IOException {
        shellMain.shellMainScreen();
    }

    public void rm(String firstComm) throws IOException {
        try {
            Files.delete(Path.of(path.toString() + "/" + firstComm));
        } catch (NoSuchFileException e) {
            System.out.println("rm: " + firstComm + ": No such file or directory");
        } finally {
            shellMain.shellMainScreen();
        }
    }

    public void pwd() throws IOException {
        System.out.println(path);
        shellMain.shellMainScreen();
    }

    public void cp(String firstComm, String secondComm) throws IOException {
        Path newPath = Paths.get(path.toString(), firstComm);
        Path copyPath = Paths.get(path.toString(), secondComm);
        try {
            Files.copy(newPath, copyPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (NoSuchFileException e) {
            System.out.println("rm: " + firstComm + ": No such file or directory");
        } finally {
            shellMain.shellMainScreen();
        }
    }

    public void touch(String firstComm) throws IOException {
        Path newPath = Paths.get(path.toString(), firstComm);
        try {
            Files.createFile(newPath);
        } catch (FileAlreadyExistsException e) {
            System.out.println("touch: " + firstComm + ": File exists");
        } finally {
            shellMain.shellMainScreen();
        }
    }
}