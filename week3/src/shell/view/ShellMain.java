package shell.view;

import shell.controller.CommandController;
import shell.input.Input;

import java.io.IOException;

public class ShellMain {
    public void shellMainScreen() throws IOException {
        Input input = new Input();
        CommandController commandController = new CommandController();
        System.out.print("B_Bong Java Shell >");
        long commandValue = input.string();
        commandController.selectCommand(commandValue);
    }
}
