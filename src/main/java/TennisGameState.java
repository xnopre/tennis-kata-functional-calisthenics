public class TennisGameState {

    private int pointsPlayer1;
    private int pointsPlayer2;

    TennisGameState() {
        this(0,0);
    }

    private TennisGameState(int pointsPlayer1, int pointsPlayer2) {
        this.pointsPlayer1 = pointsPlayer1;
        this.pointsPlayer2 = pointsPlayer2;
    }

    public boolean notFinished() {
        return true;
    }

    public String winner() {
        return null;
    }

    public String currentScore() {
        return getScorePlayer(pointsPlayer1) + " - " + getScorePlayer(pointsPlayer2);
    }

    private String getScorePlayer(int pointsPlayer) {
        return pointsPlayer == 0 ? "LOVE" : "FIFTEEN";
    }

    public TennisGameState computeNextScore(String pointWinner) {
        return new TennisGameState(this.pointsPlayer1+(pointWinner.equals("1") ? 1 : 0), this.pointsPlayer2+(pointWinner.equals("2") ? 1 : 0));
    }
}
