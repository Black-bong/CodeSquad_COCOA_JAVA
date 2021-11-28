package testpreparation.step3.resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public String inputString() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        return buf.readLine().toUpperCase();
    }
}
