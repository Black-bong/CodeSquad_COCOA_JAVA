package shell.resource;


public enum CommandList {
    C1("pwd", 0),
    C2("mkdir", 1),
    C3("rm", 2),
    C4("cd", 3),
    C5("ls", 4),
    C6("clock", 5),
    C7("exit", 6);

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