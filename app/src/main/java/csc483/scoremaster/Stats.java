package csc483.scoremaster;

public abstract class Stats {
    protected int matchesPlayed;

    public abstract void recalculateStats(int won, int EightOnBreaks, int EightBreakRuns, int EightOutOfTurns,
                                 int scratchOnEights, int innings, int points);
}
