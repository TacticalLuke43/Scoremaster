package csc483.scoremaster;

import java.util.ArrayList;

public abstract class Match {

	private String id;
	public int minPlayerCount, maxPlayerCount;
	private ArrayList<Player> players = new ArrayList<Player>();
	private Player winner;
	private boolean isComplete;

	/** Abstract b/c each sport has unique stats to track,
		 so we can't implement it in this parent class. */
	public abstract void recalculateStats();

	public String getId() {
		return id;
	}

	public ArrayList<Player> getPlayers() {
		return this.players;
	}

	/** Gotta be a list so we can pass in a variable amount. */
	public void setPlayers(ArrayList<Player> playerList) {
		if (isPlayerCountCorrect(playerList)) {
			players = playerList;
		}
	}

	public Player getWinner() {
		return this.winner;
	}

	public boolean isComplete() {
		return this.isComplete;
	}

	public void complete() {
		this.isComplete = true;
	}

	/** Utility method: since all sports are using setPlayers(),
	 *  we need a way to enforce each sports's player quantity. */
	private boolean isPlayerCountCorrect(ArrayList<Player> playerList) {
		return (playerList.size() >= minPlayerCount && playerList.size() <= maxPlayerCount);
	}
}
