package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class Boj2920 {

    private static final Logger LOG = Logger.getGlobal();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        String input = buf.readLine().replace(" ", "");

        LOG.info(input);

        switch (input) {
            case "12345678":
                System.out.println("ascending");
                break;
            case "87654321":
                System.out.println("descending");
                break;
            default:
                System.out.println("mixed");
        }
    }
}
