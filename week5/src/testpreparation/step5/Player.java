package testpreparation.step5;

public class Player {
    private int id;
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScorePoints(int score) {
        this.score = score;
        return this.score;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }
}
