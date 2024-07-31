package cricketscorecardapp;

public class Player {

    private String name;
    private int runs;
    private int ballsFaced;
    private boolean isOut;

    public Player(String name) {
        this.name = name;
        this.runs = 0;
        this.ballsFaced = 0;
        this.isOut = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Player name cannot be empty!");
        } else {
            this.name = name;
        }
    }

    public int getRuns() {
        return runs;
    }

    public void addRuns(int runs) {
        this.runs += runs;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void addBallFaced() {
        this.ballsFaced+=1;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut() {
        this.isOut = true;
    }

    public double strikeRate() {
        return (ballsFaced > 0) ? (runs * 100.0 / ballsFaced) : 0.0;
    }
}
