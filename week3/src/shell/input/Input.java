package shell.input;

import shell.resource.CommandList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

    public Long string() throws IOException {
        String command = buf.readLine();
        long commandID = CommandList.commandList(command);
        if (commandID != 0L) {
            return commandID;
        }
        System.out.println("존재하지 않는 명령어 입니다.");
        System.out.print("B_Bong Java Shell >");
        return string();
    }
}
