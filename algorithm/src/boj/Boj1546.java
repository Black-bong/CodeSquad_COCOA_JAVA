package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Boj1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Double> scores = new ArrayList<>();

        double avg = 0;
        double temp = 0;
        double sum = 0;
        double max = 0;
        int scoreCount = Integer.parseInt(buf.readLine());

        StringTokenizer str = new StringTokenizer(buf.readLine(), " ");

        for (int i = 0; i < scoreCount; i++) {
            scores.add(Double.parseDouble(str.nextToken()));
        }
        max = scores.stream().mapToDouble(x -> x).max().orElseThrow(NoSuchElementException::new);
        for (Double score : scores) {
            temp = score / max * 100;
            sum += temp;
        }
        avg = sum / scoreCount;

        StringBuilder sb = new StringBuilder();
        sb.append(avg);

        System.out.println(sb);
    }
}
