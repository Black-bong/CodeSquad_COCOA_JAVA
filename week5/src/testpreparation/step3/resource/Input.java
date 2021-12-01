package testpreparation.step3.resource;

import testpreparation.step3.controller.Commend;
import testpreparation.step3.view.PrintScreen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Input {
    public void inputString(PrintScreen printScreen) throws IOException {
        List<String> commandList = new LinkedList<>();
        int count = 0;
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        Commend commend = new Commend();
        while (true) {
            clearCommandList(commandList);
            printScreen.inputBar();
            String commands = buf.readLine().toUpperCase();
            if (commands.equals("Q")) {
                printScreen.endScreen(count);
                break;
            }
            splitString(commands, commandList);
            count += commandList.size();
            commend.saveCommend(commandList);
        }
    }

    private void clearCommandList(List<String> commandList) {
        if (!commandList.isEmpty()) {
            commandList.clear();
        }
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
