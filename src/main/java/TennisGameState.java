import java.util.HashMap;
import java.util.Map;

public class TennisGameState {

    private final Map<Integer, Integer> playersScore;

    private final Map<Integer, String> humanReadableScore;

    TennisGameState() {
        this(new HashMap<Integer, Integer>() {{
            put(1, 0);
            put(2, 0);
        }});
    }

    private TennisGameState(Map<Integer, Integer> playersScore) {
        this.playersScore = new HashMap<Integer, Integer>(playersScore);

        this.humanReadableScore = new HashMap<Integer, String>() {
            {
                put(0, "LOVE");
                put(1, "FIFTEEN");
                put(2, "THIRTY");
                put(3, "FORTY");
            }
        };
    }

    public boolean notFinished() {
        return !finished();
    }

    private boolean finished() {
        return playersScore.containsValue(4);
    }

    public String winner() {
        return playersScore.get(1) == 4 ? "1" : playersScore.get(2) == 4 ? "2" : "NONE";
    }

    public String currentScore() {
        return getScorePlayer(playersScore.get(1)) + " - " + getScorePlayer(playersScore.get(2));
    }

    private String getScorePlayer(int pointsPlayer) {
        return humanReadableScore.get(pointsPlayer);
    }

    public TennisGameState computeNextScore(String pointWinner) {
        Map<Integer,Integer> newState = playersScore;
        newState.put(Integer.parseInt(pointWinner), playersScore.get(Integer.parseInt(pointWinner)) + 1);
        return new TennisGameState(newState);
    }
}
