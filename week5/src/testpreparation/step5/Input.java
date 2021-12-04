package testpreparation.step5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    public String inputString() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String inputString = buf.readLine();
        return inputString;
    }

    public int inputInteger() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String inputString = buf.readLine();
        return Integer.parseInt(inputString);
    }
}
