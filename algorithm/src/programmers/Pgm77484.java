package programmers;

// 로또의 최고 순위와 최저 순위
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int score = 7;
        int zero = 0;
        for (var i : lottos) {
            if (i == 0) {
                zero++;
            }
            for (var j : win_nums) {
                if (i == j) {
                    score--;
                }
            }
        }
        if (score == 7) {
            score = 6;
        }
        if (zero == 0) {
            score = 1;
            zero = 5;
        }
        int[] answer = {score, zero + score};
        return answer;
    }
}

public class Pgm77484 {
}
