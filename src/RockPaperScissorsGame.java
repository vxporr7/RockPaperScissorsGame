import java.util.Scanner;
public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String playerAMove, playerBMove;
        boolean playAgain = true;

        while (playAgain) {
            // Get Player A's move
            playerAMove = getPlayerMove(in, "Player A");

            // Get Player B's move
            playerBMove = getPlayerMove(in, "Player B");

            // Determine and display the result
            String result = determineWinner(playerAMove, playerBMove);
            System.out.println(result);

            // Prompt for replay
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = in.next().equalsIgnoreCase("yes");
        }

        in.close();
    }

    private static String getPlayerMove(Scanner scanner, String player) {
        String move;
        while (true) {
            System.out.print(player + ", enter your move (R, P, S): ");
            move = scanner.next().toUpperCase();
            if (move.equals("R") || move.equals("P") || move.equals("S")) {
                break;
            } else {
                System.out.println("Invalid move. Please enter R, P, or S.");
            }
        }
        return move;
    }

    private static String determineWinner(String playerAMove, String playerBMove) {
        if (playerAMove.equals(playerBMove)) {
            return playerAMove + " vs " + playerBMove + " it's a Tie!";
        }

        switch (playerAMove) {
            case "R":
                return playerBMove.equals("S") ? "Rock breaks Scissors. Player A wins!" : "Paper covers Rock. Player B wins!";
            case "P":
                return playerBMove.equals("R") ? "Paper covers Rock. Player A wins!" : "Scissors cuts Paper. Player B wins!";
            case "S":
                return playerBMove.equals("P") ? "Scissors cuts Paper. Player A wins!" : "Rock breaks Scissors. Player B wins!";
            default:
                return "Invalid move.";
        }
    }
    }