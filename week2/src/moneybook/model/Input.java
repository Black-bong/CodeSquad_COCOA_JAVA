package moneybook.model;

import moneybook.singleton.BufferedReaderSingleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Input {
    BufferedReader br = BufferedReaderSingleton.getInstance();
    StringTokenizer st = new StringTokenizer("");
    public String inputString() throws IOException {
        if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public void inputInteger() {

    }

}