package shell.view;

import shell.controller.CommandController;
import shell.input.Input;
import shell.resource.CommandList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShellMain {
    public void shellMainScreen() throws IOException {
        List<String> inputString = new ArrayList<>();
        Input input = new Input();
        CommandController commandController = new CommandController();
        System.out.print("B_Bong Java Shell> ");
        inputString = input.string();

        try {
            int commandID = CommandList.commandList(inputString.get(0));
            String additionalCommand = inputString.get(1);
            commandController.selectCommand(commandID, additionalCommand);
        } catch (IllegalArgumentException e) {
            System.out.println("존재하지 않는 명령어 입니다.");
            shellMainScreen();
        }
    }
}