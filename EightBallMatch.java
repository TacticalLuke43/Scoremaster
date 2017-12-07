package csc483.scoremaster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class EightBallMatch extends Match {
	
	public EightBallMatch(Group group, ArrayList<Player> players) {
		this.group = group; // since two players could share more than one group, you have to specify which one when you create the group.
		this.players = players;
	}

	private ArrayList<EightBallGame> gameList = new ArrayList<EightBallGame>();
	
	private int gameCounter = 0;
	
	private Group group;
	
	/** player 1 is index 0, player 2 is index 1; don't blame me, blame array indexing. */
	private int[] gamesWon        = {0,0},
				  points          = {0,0},
				  EightBreakRuns  = {0,0},
				  EightOnBreaks   = {0,0},
				  EightOutOfTurns = {0,0},
				  scratchOnEights = {0,0};
				  
	private ArrayList<Player> players = new ArrayList<Player>();
	
	/** Recalculates PlayerStats & GroupStats on conclusion of match. */
	@Override
	public void recalculateStats() {
		// player stats
		for (int playerIndex = 0; playerIndex < 2; playerIndex++) {
			Player player = players.get(playerIndex);
			// find player index, then use that to access array of each stat
			PlayerStats stats = player.getStats();
			stats.gamesWon        += this.gamesWon[playerIndex];
			stats.points          += this.points[playerIndex];
			stats.EightBreakRuns  += this.EightBreakRuns[playerIndex];
			stats.EightOnBreaks   += this.EightOnBreaks[playerIndex];
			stats.EightOutOfTurns += this.EightOutOfTurns[playerIndex];
			stats.scratchOnEights += this.scratchOnEights[playerIndex];
		} // @TODO look into using reflection to accomplish this cleaner.
		
		//group stats: players are always in the same group
		GroupStats stats = this.group.getStats();
		// skip gamesWon, there's no use keeping track of it.
		stats.matchesPlayed++;
		// have to sum the two players' stats, but can't use Java 8's Array summation method
		for (int element : this.points)          stats.addPoints(element);
		for (int element : this.EightBreakRuns)  stats.addEightBreakRuns(element);
		for (int element : this.EightOnBreaks)   stats.addEightOnBreaks(element);
		for (int element : this.EightOutOfTurns) stats.addEightOutOfTurns(element);
		for (int element : this.scratchOnEights) stats.addScratchOnEights(element);
	}
	
	public void addGame() {
		// idk what else needs to happen here
		this.gameCounter++;
	}
	
	/** idk if needed, depends on what else has to happen */
	public void finish() {
		recalculateStats();
	}
}