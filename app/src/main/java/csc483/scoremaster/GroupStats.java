package csc483.scoremaster;

import java.util.ArrayList;

/**
 * Created by T on 11/26/2017.
 */


public class GroupStats extends Stats {
    // constructor
    public GroupStats (Group thisGroup) {
        updateStatsTable(thisGroup);
    }

// TODO matches played only??
    //variables
    //left out the game related ones, i dont think we need them?
    //I also left out winrate and avginnings as variables because they can just be calculated on the spot
    private int matchesWon;
    private int points;
    private int innings;
    private int EightOnBreaks;
    private int EightBreakRuns;
    private int EightOutOfTurns;
    private int scratchOnEights;
    private GroupStatsTable statsTable;

    //gets
    public int getMatchesPlayed() {
        return matchesPlayed;
    }
    public int getMatchesWons() {
        return matchesWon;
    }
    public int getPoints() {
        return points;
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
    public ArrayList<Player> getPlayers() {
        // TODO

        // iterate through array of PlayerStat objects

        // build array of Players to return


        return
    }
    //sets

    // for these first one it just increments them by one, since you can only play 1 match at a time
    private void incrementMatchesPlayed() {
        this.matchesPlayed++;
    }
    //for this its 0 if you lose, 1 if you win
    private void incrementMatchesWon(int won) {this.matchesWon += won;}
    //current value + passed value
    private void incrementEightOnBreaks()   { this.EightOnBreaks++; }
    private void incrementEightBreakRuns()  { this.EightBreakRuns++; }
    private void incrementEightOutOfTurns() { this.EightOutOfTurns++; }
    private void incrementScratchOnEights() { this.scratchOnEights++; }
    private void incrementInnings()         { this.innings++; }
    private void incrementPoints()          { this.points++; }

    //calculations TODO
    public GroupStatsTable updateStatsTable(Group thisGroup) {
    }

    public void addPlayer(Player p) {
    // TODO

    }

    public boolean removePlayer(Player p) {
    // TODO
    }

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
    @Override
    public void recalculateStats(int won, int EightOnBreaks, int EightBreakRuns,
                                 int EightOutOfTurns, int scratchOnEights, int innings, int points){
        incrementMatchesPlayed();
        incrementMatchesWon(won);
        incrementEightOnBreaks(EightOnBreaks);
        incrementEightBreakRuns(EightBreakRuns);
        incrementEightOutOfTurns(EightOutOfTurns);
        incrementScratchOnEights(scratchOnEights);
        incrementInnings(innings);
        incrementPoints(points);
    }

}
