package csc483.scoremaster;

import java.util.ArrayList;

public class Player {

    private String id;

    private String name;

    private ArrayList<Group> groups;

    private PlayerStats stats;

    private ArrayList<Match> matches;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) { // might want to share a name validator method with Group.
        this.name = newName;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public PlayerStats getStats() {
        return stats;
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }
}
