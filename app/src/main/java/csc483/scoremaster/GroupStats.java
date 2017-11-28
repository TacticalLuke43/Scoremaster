package csc483.scoremaster;

/**
 * Created by T on 11/26/2017.
 */

//brain hurts, going to need to ask about this, i really need to know how our firebase is going to be set up
    //for now its just a copy paste of the playerstats

public class GroupStats {
    //variables
    //left out the game related ones, i dont think we need them?
    //I also left out winrate and avginnings as variables because they can just be calculated on the spot
    int matchesPlayed;
    int matchesWon;
    int points;
    int innings;


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

    private void setInnings(int innings) {
        this.innings = this.innings + innings;
    }
    private void setPoints(int points) {
        this.points = this.points + points;
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
        setInnings(innings);
        setPoints(points);
    }

}
