package shell.view;

import shell.controller.CommandController;
import shell.input.Input;
import shell.resource.CommandList;

import java.io.IOException;

public class ShellMain {
    public void shellMainScreen() throws IOException {
        Input input = new Input();
        CommandController commandController = new CommandController();
        System.out.print("B_Bong Java Shell >");
        String inputString = input.string();

        try {
            int commandID = CommandList.commandList(inputString);
            commandController.selectCommand(commandID);
        } catch (IllegalArgumentException e) {
            System.out.println("존재하지 않는 명령어 입니다.");
            shellMainScreen();
        }
    }
}