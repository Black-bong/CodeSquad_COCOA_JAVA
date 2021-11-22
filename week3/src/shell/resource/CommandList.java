package shell.resource;


public enum CommandList {
    PWD("pwd", 0),
    MKDIR("mkdir", 1),
    RM("rm", 2),
    CD("cd", 3),
    LS("ls", 4),
    CLOCK("clock", 5),
    EXIT("exit", 6),
    CP("cp", 7),
    TOUCH("touch", 8);

    private final String command;
    private final int commandID;

    CommandList(String command, int commandID) {
        this.command = command;
        this.commandID = commandID;
    }

    public boolean isSamCommand(String command) {
        return this.command.equals(command);
    }

    public static int commandList(String command) {
        for (var c : CommandList.values()) {
            if (c.isSamCommand(command)) {
                return c.commandID;
            }
        }
        throw new IllegalArgumentException();
    }
}