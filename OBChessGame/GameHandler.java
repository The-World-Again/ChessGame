import java.util.Arrays;
import java.util.Scanner;
public class GameHandler {
    static Scanner sc = new Scanner(System.in);
    static int turnCount = 1;
    Board gameBoard = new Board();
    public void runGame() {
        gameBoard.newGame();
        System.out.println();
        gameBoard.movePiece("H5","D5");
        gameBoard.showBoard();
        System.out.println(Board.allMoves(gameBoard.getPiece("B1")));
        System.out.println(Arrays.toString(gameBoard.getPiece("B1").getPose()));
        gameBoard.movePiece("B1","D1");
        System.out.println();
        gameBoard.showBoard();
        System.out.println(Board.allMoves(gameBoard.getPiece("D1")));
        System.out.println(gameBoard.getPiece("D1").possibleMoves());
        //int[] pickedPiece = PickPiece();

    }
    public void gameCycle() {
        gameBoard.newGame();
        System.out.println();
    }
    public int[] PickPiece() {
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
            if (tempPiece == null || tempPiece.getType().equals("information")) {
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

        int[] piece = {p.getY(),p.getX()};
        System.out.println(Arrays.toString(piece));
        return piece;
    }
    public int[] pickPosition() {
        System.out.println("\nSelect a place to move that piece");
        boolean valid = false;
        int[] position = new int[2];
        while (!valid) {
            valid = true;
            position = gameBoard.boardPosition(sc.nextLine().trim());
            if (position == null) {
                System.out.println("\nThat is not a valid spot");
                valid = false;
                continue;
            }
        }
        return position;
    }
}
