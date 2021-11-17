package shell.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

    public String string() throws IOException {
        return buf.readLine();
    }
}