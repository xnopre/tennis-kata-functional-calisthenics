import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisGameTest {

    @Test
    public void initial_score_should_be_love_love() {
        TennisGameState state = new TennisGameState();
        assertThat(state.currentScore()).isEqualTo("LOVE - LOVE");
    }

    @Test
    public void score_should_be_fifteen_love_when_first_player_won_first_point() {
        TennisGameState state = new TennisGameState();
        TennisGameState nextState = state.computeNextScore("1");
        assertThat(nextState.currentScore()).isEqualTo("FIFTEEN - LOVE");
    }

    @Test
    public void score_should_be_fifteen_fifteen_when_both_players_won_one_point() {
        TennisGameState state = new TennisGameState();
        TennisGameState nextState = state.computeNextScore("1").computeNextScore("2");
        assertThat(nextState.currentScore()).isEqualTo("FIFTEEN - FIFTEEN");
    }

    @Test
    public void score_should_be_fifteen_thirty() {
        TennisGameState state = new TennisGameState();
        TennisGameState nextState = state.computeNextScore("1").computeNextScore("2").computeNextScore("2");
        assertThat(nextState.currentScore()).isEqualTo("FIFTEEN - THIRTY");
    }

    @Test
    public void game_should_stop_when_one_player_has_more_than_forty() {
        TennisGameState state = new TennisGameState();
        TennisGameState nextState = state
                .computeNextScore("1") // 15 - 0
                .computeNextScore("2") // 15 - 15
                .computeNextScore("2") // 15 - 30
                .computeNextScore("2") // 15 - 40
                .computeNextScore("2"); // Player 2 won
        assertThat(nextState.notFinished()).isFalse();
    }
}
