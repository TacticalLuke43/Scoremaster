package csc483.scoremaster;

import java.util.ArrayList;
import java.util.List;

public class Group {
	/** Constructor without group name **/
	public Group (Player admin) {
		this(admin, "Untitled");
	}
	
	/** Constructor with group name **/
	public Group (Player admin, String groupName) {
		this.id = /* Firebase stuff */ ;
		setName(groupName);
		this.admins.add(admin);
	}

	private String id;
	private String name;
//	private List<Integer> playerIDs = new ArrayList<Integer>();
	private GroupStats stats = new GroupStats();
	private ArrayList<EightBallMatch> matches = new ArrayList<EightBallMatch>();
	private ArrayList<Player> admins = new ArrayList<Player>(); // more than one admin?

	public ArrayList<Player> getPlayers() {
		return this.stats.getPlayers();
	}

	public void addPlayer(Player p) {
		p.addToGroup(this);
		stats.addPlayer(p);
	}
	
	/** @returns true if playerID was in list. **/	
	public boolean removePlayer(Player p) {
		p.removeFromGroup(this);
		return stats.removePlayer(p);
	}

	public void editAdmin(Player newAdmin) {
		// admins.clear(); TODO do we want to allow multiple admins?
		admins.add(newAdmin);
	}

	public String startMatch(ArrayList<Player> players) { // pass in which players are playing this match
		EightBallMatch match = new EightBallMatch(this, players);
		this.matches.add(match);
		return match.getID(); // might come in handy.
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String getID() {
		return this.id;
	}

	public GroupStats getStats() {
		return this.stats;
	}

	public List<Player> getAdmins() {
		return this.admins;
	}

	public List<EightBallMatch> getMatches() {
		return this.matches;
	}
}
