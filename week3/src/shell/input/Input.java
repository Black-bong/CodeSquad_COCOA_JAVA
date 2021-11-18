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
        String firstInputString = null;
        String secondInputString;
        String inputTrim = null;
        //TODO 코드가 너무 지저분하다
        try {
            firstInputString = str.nextToken();
            inputTrim = str.nextToken();
            secondInputString = str.nextToken();
            inputValue.add(firstInputString);
            inputValue.add(inputTrim);
            inputValue.add(secondInputString);
        } catch (NoSuchElementException e) {
            inputValue.add(firstInputString);
            inputValue.add(inputTrim);
            inputValue.add("");
            return inputValue;
        } catch (Exception e) {
            inputValue.add(firstInputString);
            inputValue.add("");
            inputValue.add("");
            return inputValue;
        }
        return inputValue;
    }
}