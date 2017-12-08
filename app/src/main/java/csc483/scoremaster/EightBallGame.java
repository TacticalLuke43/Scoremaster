package csc483.scoremaster;

import java.util.ArrayList;

public class EightBallGame extends Game {

    public EightBallGame(int gameNumber) {this.gameNumber = gameNumber;}

    // not sure if this should be 1- or 0-indexed TODO
    public int gameNumber = 0;
    public int inningCounter = 0;

    private int[]
            EightBreakRuns  = {0,0},
            EightOnBreaks   = {0,0},
            EightOutOfTurns = {0,0},
            scratchOnEights = {0,0};
}
