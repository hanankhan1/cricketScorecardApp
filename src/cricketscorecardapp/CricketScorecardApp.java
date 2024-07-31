package cricketscorecardapp;

import java.util.Scanner;

public class CricketScorecardApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. ENTER THE APP ");
            System.out.println("0. EXIT THE APP ");
            int choice1 = input.nextInt();
            input.nextLine();  // Consume newline

            switch (choice1) {
                case 1: {

                    String team1Name;
                    while (true) {
                        System.out.println("ENTER THE NAME OF TEAM 1:");
                        team1Name = input.nextLine();
                        if (!team1Name.trim().isEmpty()) {
                            break;
                        } else {
                            System.out.println("Team name cannot be empty. Please enter a valid name.");
                        }
                    }
                    Team team1 = new Team(team1Name);
                    System.out.println("Team 1 -> " + team1.getName());
//here 11 is the number of players
                    for (int i = 0; i < 11; i++) {
                        System.out.println("ENTER NAME OF PLAYER " + (i + 1) + " OF TEAM 1:");
                        String playerName = input.nextLine();
                        if (playerName.isEmpty()) {
                            System.out.println("Player name cannot be empty!");
                            i--;
                        } else {
                            team1.addPlayer(new Player(playerName));
                        }
                    }
                    String team2Name;
                    while (true) {
                        System.out.println("ENTER THE NAME OF TEAM 1:");
                        team2Name = input.nextLine();
                        if (!team2Name.trim().isEmpty()) {
                            break;
                        } else {
                            System.out.println("Team name cannot be empty. Please enter a valid name.");
                        }
                    }
                    Team team2 = new Team(team2Name);
                    System.out.println("Team 1 -> " + team2.getName());

                    for (int i = 0; i < 11; i++) {
                        System.out.println("ENTER NAME OF PLAYER " + (i + 1) + " OF TEAM 2:");
                        String playerName = input.nextLine();
                        if (playerName.isEmpty()) {
                            System.out.println("Player name cannot be empty!");
                            i--;  // Decrement counter to retry this player's entry
                        } else {
                            team2.addPlayer(new Player(playerName));
                        }
                    }

                    Match match = new Match(team1, team2);

                    while (true) {
                        System.out.println("\nMatch Menu:");
                        System.out.println("1. Conduct Toss");
                        System.out.println("2. Play Innings for " + team1Name);
                        System.out.println("3. Play Innings for " + team2Name);
                        System.out.println("4. Display Scorecard for " + team1Name);
                        System.out.println("5. Display Scorecard for " + team2Name);
                        System.out.println("6. Declare Winner");
                        System.out.println("7. Exit");
                        System.out.print("Choose an option: ");

                        int choice = input.nextInt();
                        input.nextLine();

                        switch (choice) {
                            case 1:
                                match.conductToss();
                                break;

                            case 2:
                                if (match.getBattingFirst() == null) {
                                    System.out.println("CONDUCT THE TOSS FIRST....!");
                                } else {
                                    match.playInnings(match.getBattingFirst());
                                }
                                break;

                            case 3:
                                if (match.getBattingSecond() == null) {
                                    System.out.println("CONDUCT THE TOSS FIRST....!");
                                } else {
                                    match.playInnings(match.getBattingSecond());
                                }
                                break;

                            case 4:
                                match.displayScorecard(team1);
                                break;

                            case 5:
                                match.displayScorecard(team2);
                                break;

                            case 6:
                                match.declareWinner();
                                break;

                            case 7:
                                System.out.println("EXITING CURRENT GAME...");

                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                }

                case 0:
                    System.out.println("EXITING APP...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
