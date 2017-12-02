package csc483.scoremaster;

import java.util.ArrayList;
import java.util.List;

public class Group {
	/** Constructor without group name **/
	public Group (csc483.scoremaster.Player admin) {
		this(admin, "Untitled");
	}
	
	/** Constructor with group name **/
	public Group (csc483.scoremaster.Player admin, String groupName) {
		this.id = "test";/* Firebase stuff */ ;
		//setName(groupName);
		this.admins.add(admin);
	}

	private String id;
	private String name;
//	private List<Integer> playerIDs = new ArrayList<Integer>();
	private GroupStats stats = new GroupStats();
	private ArrayList<csc483.scoremaster.EightBallMatch> matches = new ArrayList<csc483.scoremaster.EightBallMatch>();
	private ArrayList<csc483.scoremaster.Player> admins = new ArrayList<csc483.scoremaster.Player>(); // more than one admin?

	/*public ArrayList<csc483.scoremaster.Player> getPlayers() {
		//return this.stats.getPlayers();
	}*/

	/*public void addPlayer(csc483.scoremaster.Player p) {
		p.addToGroup(this);
		stats.addPlayer(p);
	}*/
	
	/** @returns true if playerID was in list. *
	public boolean removePlayer(csc483.scoremaster.Player p) {
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
	}*/
}