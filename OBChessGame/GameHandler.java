import java.util.Scanner;
public class GameHandler {
    static Board gameBoard = new Board();
    static Scanner sc = new Scanner(System.in);
    static int turnCount = 1;
    public static void runGame() {
        gameBoard.newGame();
        System.out.println();
        nextMove("a");
    }

    public static void nextMove(String s) {
        if (turnCount % 2 == 1) {
            System.out.println("It is white's turn. \n Select a piece to move");
        }
        else {
            System.out.println("It is black's turn. \n Select a piece to move");
        }

    }
}
