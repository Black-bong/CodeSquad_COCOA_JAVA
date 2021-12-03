package testpreparation.step3.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Input {

    public void inputString(List<String> commandList) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String commands = buf.readLine().toUpperCase();
        splitString(commands, commandList);
    }

    private void splitString(String commands, List<String> commandList) {
        for (int i = 0; i < commands.length(); i++) {
            int lastIndex = commandList.size() - 1;
            String command = Character.toString(commands.charAt(i));
            if (command.equals("'")) {
                commandList.set(lastIndex, commandList.get(lastIndex) + "'");
                continue;
            }
            isInteger(command, commandList);
        }
    }

    private void isInteger(String command, List<String> commandList) {
        int lastIndex = commandList.size() - 1;
        try {
            for (int j = 0; j < Integer.parseInt(command) - 1; j++) {
                commandList.add(commandList.get(lastIndex));
            }
        } catch (NumberFormatException e) {
            commandList.add(command);
        }
    }
}