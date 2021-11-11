package moneybook.model;

import moneybook.singleton.BufferedReaderSingleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Input {
    private static final BufferedReader br = BufferedReaderSingleton.getInstance();

    public String inputString() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        return st.nextToken();
    }

    public void inputInteger() {

    }

}