package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj8958 {

    static int N;
    static ArrayList<String> oxList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve(oxList);
    }

    static void input() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buf.readLine());
        for (int i = 0; i < N; i++) {
            createList(buf.readLine());
        }
    }

    static void createList(String ox) {
        oxList.add(ox);
    }

    static void solve(ArrayList<String> list) {
        int start = 0;
        int count = 0;
        int sum = 0;
        int value = 0;

        while (count < N) {
            String listLength = list.get(count);
            int end = listLength.length();

            for (int i = start; i < end; i ++) {
                if (list.get(count).charAt(i) == 'O') {
                    value++;
                    sum += value;
                }
                if (list.get(count).charAt(i) == 'X') {
                    value = 0;
                }
            }
            System.out.println(sum);
            count++;
            sum = 0;
            value = 0;
        }
    }
}