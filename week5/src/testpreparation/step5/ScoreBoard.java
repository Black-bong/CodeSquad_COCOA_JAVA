package testpreparation.step5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {
    private final Map<Integer, Player> players = new HashMap<>();
    private static int sequence = 0;
    private final List<String> score = new ArrayList<>();

    public void savePlayer(Player player) {
        player.setId(++sequence);
        players.put(sequence, player);
    }

    public void printRoundPoint() {
        StringBuilder sb = new StringBuilder();
        sb.append("| ");
        sb.append(players.get(1).getName());
        checkRoundPoint(players.get(1).getScore(), sb);
        for (String s : score) {
            sb.append(s);
            sb.append(" | ");
        }
        sb.append(" | ");
        System.out.print(sb);
        System.out.println();
    }

    private void checkRoundPoint(int point, StringBuilder sb) {
        if (point == 10) {
            sb.append(" | ");
            score.add("X");
        }
    }
}