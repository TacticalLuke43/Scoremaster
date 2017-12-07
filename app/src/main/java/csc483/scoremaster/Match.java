package csc483.scoremaster;

import java.util.ArrayList;

public abstract class Match implements Lookupable { // see note on Group.getStats()

	private String id;
	private ArrayList<Player> players = new ArrayList<Player>();
	private Player winner;
	private boolean complete;

	/** 'Abstract' b/c each sport has unique stats to track,
		 so we can't implement it in this parent class. */
	public abstract void recalculateStats();

	public String getId() {
		return id;
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	public Player getWinner() {
		return this.winner;
	}

	public boolean isComplete() {
		return this.complete;
	}

	public void setComplete(boolean setComplete) {
		this.complete = setComplete;
	}
}
