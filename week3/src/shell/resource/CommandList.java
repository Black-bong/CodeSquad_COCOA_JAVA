package shell.resource;


public enum CommandList {
    C1("pwd", 1),
    C2("mkdir", 2),
    C3("rm", 3),
    C4("cd", 4),
    C5("ls", 5),
    C6("clock", 6);

    private final String command;
    private final long commandID;

    CommandList(String command, int commandID) {
        this.command = command;
        this.commandID = commandID;
    }

    public boolean isSamCommand(String command) {
        return this.command.equals(command);
    }

    public static long commandList(String command) {
        for (var c : CommandList.values()) {
            if(c.isSamCommand(command)) {
                return c.commandID;
            }
        }
        return 0L;
    }
}