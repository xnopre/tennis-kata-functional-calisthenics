public class TennisGameState {

    private final int pointsPlayer1;
    private final int pointsPlayer2;

    TennisGameState() {
        this(0,0);
    }

    private TennisGameState(int pointsPlayer1, int pointsPlayer2) {
        this.pointsPlayer1 = pointsPlayer1;
        this.pointsPlayer2 = pointsPlayer2;
    }

    public boolean notFinished() {
        return pointsPlayer1 != 4 && pointsPlayer2 != 4;
    }

    public String winner() {
        return pointsPlayer1 == 4 ? "Player 1" : "Player 2";
    }

    public String currentScore() {
        if (pointsPlayer1 >= 3 && pointsPlayer2 >=  3) {
            return "DEUCE";
        }
        return getScorePlayer(pointsPlayer1) + " - " + getScorePlayer(pointsPlayer2);
    }

    private String getScorePlayer(int pointsPlayer) {
        return SCORE_FROM_POINTS[pointsPlayer];
    }

    public TennisGameState computeNextScore(String pointWinner) {
        return new TennisGameState(this.pointsPlayer1+(pointWinner.equals("1") ? 1 : 0), this.pointsPlayer2+(pointWinner.equals("2") ? 1 : 0));
    }

    private static final String[] SCORE_FROM_POINTS = { "LOVE", "FIFTEEN", "THIRTY", "FORTY" };
}
