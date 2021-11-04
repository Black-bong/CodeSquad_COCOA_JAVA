package inputoutputstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderEx {
    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String readLineEx = buf.readLine();
        int readEx = buf.read();

        buf.close();

        System.out.println("readLineEx = " + readLineEx);
        System.out.println("readEx = " + readEx);
    }
}
