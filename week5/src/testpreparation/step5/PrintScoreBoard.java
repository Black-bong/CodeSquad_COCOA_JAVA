package testpreparation.step5;

import java.io.IOException;

public class PrintScoreBoard {

    private static final Input input = new Input();

    public void printGameRound() {
        StringBuilder sb = new StringBuilder();
        sb.append("| NAME |");
        for (int i = 1; i < 11; i++) {
            sb.append("  ");
            sb.append(String.format("%02d", i));
            sb.append("  |");
        }
        System.out.println(sb);
    }

    public String printInputPlayerName() throws IOException {
        System.out.print("플레이어 이름을 입력하세요: ");
        return input.inputString();
    }

    public void printInputScoreBar(Player player) throws IOException {
        System.out.print(player.getName() + "'s turn : ");
        player.getScorePoints(input.inputInteger());
    }
}