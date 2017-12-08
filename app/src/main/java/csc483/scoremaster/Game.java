package csc483.scoremaster;

import java.util.ArrayList;

/** Since players vary from match-to-match and not game-to-game,
 * I don't think the Game class needs to know the player list. */
public abstract class Game {
    private Player winner;
    public Player getWinner() {return winner;}
    public void setWinner(Player p) {winner = p;}
}
