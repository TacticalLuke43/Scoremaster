package csc483.scoremaster;

/**
 * Created by T on 11/26/2017.
 */
//basic structure for the class, i have no idea how firebase works so this may very well get changed

public class PlayerStats {
    // constructor
    public PlayerStats (Player player) {
        // TODO ??
    }


    //variables
    //left out the game related ones, i dont think we need them?
    //I also left out winrate and avginnings as variables because they can just be calculated on the spot
    private int matchesPlayed;
    private int matchesWon;
    private int wins;
    private int innings;
    private int EightOnBreaks;
    private int EightBreakRuns;
    private int EightOutOfTurns;
    private int scratchOnEights;

    //gets
    public int getMatchesPlayed() {
        return matchesPlayed;
    }
    public int getMatchesWon() {
        return matchesWon;
    }
    public int getEightOnBreaks() {
        return EightOnBreaks;
    }
    public int getEightBreakRuns() {
        return EightBreakRuns;
    }
    public int getEightOutOfTurns() {
        return EightOutOfTurns;
    }
    public int getScratchOnEights() {
        return scratchOnEights;
    }
    public int getWins() {
        return wins;
    }
    //sets

    // for these first one it just increments them by one, since you can only play 1 match at a time
    private void setMatchesPlayed() {
        this.matchesPlayed = this.matchesPlayed + 1;
    }
    //for this its 0 if you lose, 1 if you win
    private void setMatchesWon(int won) {
        this.matchesWon = this.matchesWon + won;
    }
    //current value + passed value
    private void setEightOnBreaks(int eightOnBreaks) {
        this.EightOnBreaks = this.EightOnBreaks + eightOnBreaks;
    }
    private void setEightBreakRuns(int eightBreakRuns) {
        this.EightBreakRuns++;
    }
    private void setEightOutOfTurns(int eightOutOfTurns) {
        this.EightOutOfTurns++;
    }
    private void setScratchOnEights(int scratchOnEights) {
        this.scratchOnEights++;
    }
    private void setInnings(int innings) {
        this.innings++;
    }
    private void setWins(int wins) {
        this.wins++;
    }

    //calculations
    public int calcWinPercent(){
        //initializing
        float winPercentFloat = 0;
        int winPercent = 0;
        winPercentFloat = matchesWon/matchesPlayed;
        winPercent = (int) Math.ceil(winPercentFloat * 100);
        return winPercent;
    }
    public int calcAverageInnings(){
        //initializing
        int avgInnings = 0;
        avgInnings = (int) Math.ceil(innings/matchesPlayed);
        return avgInnings;
    }
    //calls all the sets
    public void recalcStats(int won, int breaks, int runs, int outOfTurns, int scratchOn8s, int innings, int points){
        setMatchesPlayed();
        setMatchesWon(won);
        setEightOnBreaks(breaks);
        setEightBreakRuns(runs);
        setEightOutOfTurns(outOfTurns);
        setScratchOnEights(scratchOn8s);
        setInnings(innings);
        setWins(points);
    }
}
