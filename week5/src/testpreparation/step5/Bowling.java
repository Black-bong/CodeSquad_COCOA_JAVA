package testpreparation.step5;

import java.io.IOException;

public class Bowling {

    public void start() throws IOException {
        int gameCount = 0;
        int maxCount = 12;
        PrintScoreBoard printScoreBoard = new PrintScoreBoard();
        ScoreBoard scoreBoard = new ScoreBoard();
        Player player = createPlayer(printScoreBoard);
        while(gameCount < maxCount) {
            printScoreBoard.printInputScoreBar(player);
            printScoreBoard.printGameRound();
            createScoreBoard(player, scoreBoard);
            scoreBoard.printRoundPoint();
            gameCount++;
        }
    }

    private Player createPlayer(PrintScoreBoard printScoreBoard) throws IOException {
        return new Player(printScoreBoard.printInputPlayerName());
    }

    private void createScoreBoard(Player player, ScoreBoard scoreBoard) {
        scoreBoard.savePlayer(player);
    }
}