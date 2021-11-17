package shell.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Input {

    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

    public List<String> string() throws IOException {
        List<String> inputValue = new ArrayList<>();
        StringTokenizer str = new StringTokenizer(buf.readLine(), " ");
        String inputString = str.nextToken();
        try {
            String inputTrim = str.nextToken();
            inputValue.add(inputString);
            inputValue.add(inputTrim);
        } catch (NoSuchElementException e) {
            inputValue.add(inputString);
            inputValue.add("");
            return inputValue;
        }
        return inputValue;
    }
}