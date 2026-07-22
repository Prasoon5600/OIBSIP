package Game;

public class Score {

    private int round;
    private int attempts;

    public Score(int round, int attempts) {
        this.round = round;
        this.attempts = attempts;
    }

    @Override
    public String toString() {
        return "Round " + round + " - Guessed in " + attempts + " attempts";
    }
}