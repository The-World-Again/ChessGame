import java.util.Arrays;
import java.util.Scanner;
public class GameHandler {
    static Board gameBoard = new Board();
    static Scanner sc = new Scanner(System.in);
    static int turnCount = 1;
    public static void runGame() {
        gameBoard.newGame();
        System.out.println();
        int[] pickedPiece = PickPiece();
    }

    public static int[] PickPiece() {
        boolean white = (turnCount % 2 == 1);
        if (white) {
            System.out.println("It is white's turn. \nSelect a piece to move\n");
        }
        else {
            System.out.println("It is black's turn. \nSelect a piece to move\n");
        }
        boolean valid = false;
        Piece p = new Information("PLACEHOLDER",0,0);

        while (!valid) {
            valid = true;
            String input = sc.nextLine().trim();

            if (input.length() != 2) {
                System.out.println("That is not a valid position");
                valid = false;
                continue;
            }

            Piece tempPiece = gameBoard.getPiece(input);
            if (tempPiece.getType().equals("information")) {
                System.out.println("That is not a valid piece");
                valid = false;
                continue;
            }


            if(white) {
                if (!(tempPiece.getColor().equals("white"))) {
                    System.out.println("That is not one of your pieces");
                    valid = false;
                    continue;
                }
            }
            else {
                if(!(tempPiece.getColor().equals("black"))) {
                    System.out.println("That is not one of your pieces");
                    valid = false;
                    continue;
                }
            }

            p = tempPiece;
        }

        int[] move = {p.getY(),p.getX()};
        System.out.println(Arrays.toString(move));
        return move;
    }
}
