package cricketscorecardapp;

import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Player> players;
    private int totalRuns;
    private int wickets;
    private int overs;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
        this.totalRuns = 0;
        this.wickets = 0;
        this.overs = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Team name cannot be empty!");
        } else {
            this.name = name;
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void addRuns(int runs) {
        this.totalRuns += runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void addWickets() {
        this.wickets+=1;
    }

    public int getOvers() {
        return overs;
    }

    public void addOvers() {
        this.overs+=1;
    }
}
