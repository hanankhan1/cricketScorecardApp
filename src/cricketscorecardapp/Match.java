package cricketscorecardapp;

import java.util.Random;

import static java.lang.Math.round;

public class Match {

    private Team team1;
    private Team team2;
    private Team battingFirst;
    private Team battingSecond;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.battingFirst = null;
        this.battingSecond = null;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Team getBattingFirst() {
        return battingFirst;
    }

    public void setBattingFirst(Team battingFirst) {
        this.battingFirst = battingFirst;
    }

    public Team getBattingSecond() {
        return battingSecond;
    }

    public void setBattingSecond(Team battingSecond) {
        this.battingSecond = battingSecond;
    }

    public void conductToss() {
        Random random = new Random();
        if (random.nextBoolean()) {
            battingFirst = team1;
            battingSecond = team2;
        } else {
            battingFirst = team2;
            battingSecond = team1;
        }
        System.out.println(battingFirst.getName() + " will bat first.");
    }

    public void playInnings(Team team) {
        Random random = new Random();
        for (int over = 1; over <= 20; over++) {
            System.out.println("Over " + over + ":");
            for (int ball = 1; ball <= 6; ball++) {
                int run = random.nextInt(7);
                boolean wicket = random.nextBoolean();
                Player currentBatsman = team.getPlayers().get(team.getWickets());
                if (wicket) {
                    System.out.println("Wicket -> " + currentBatsman.getName() + " is out!");
                    currentBatsman.setOut();
                    team.addWickets();
                    if (team.getWickets() == 11) {
                        System.out.println("All out!");
                        return;  // Exit innings if all players are out
                    }
                } else {
                    System.out.println("Ball " + ball + ":");
                    currentBatsman.addRuns(run);
                    currentBatsman.addBallFaced();
                    team.addRuns(run);
                }
            }
            team.addOvers();
        }
    }

    public void displayScorecard(Team team) {
        System.out.println("Scorecard for " + team.getName() + ":");
        for (int i=0;i<team.getPlayers().size();i++) {
            Player player=team.getPlayers().get(i);
            System.out.println(player.getName() + ": " + player.getRuns() + " runs, " + player.getBallsFaced() + " balls, Strike Rate: " + round(player.strikeRate()));
        }
        System.out.println("Total Runs: " + team.getTotalRuns() + " Total wickets " + team.getWickets() + " in " + team.getOvers() + " overs");
    }

    public void declareWinner() {
        if (team1.getTotalRuns() > team2.getTotalRuns()) {
            System.out.println(team1.getName() + " is the winner with a total score of " + team1.getTotalRuns());
        } else if (team2.getTotalRuns() > team1.getTotalRuns()) {
            System.out.println(team2.getName() + " is the winner with a total score of " + team2.getTotalRuns());
        } else {
            System.out.println("The match is a tie!");
        }
    }
}
