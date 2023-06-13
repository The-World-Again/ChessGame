import java.util.Arrays;
import java.util.Scanner;
public class GameHandler {
    static Scanner sc = new Scanner(System.in);
    static int turnCount = 1;
    Board gameBoard = new Board();
    public void runGame() {
        gameBoard.newGame();
        System.out.println();
        String og = pickPiece();
        String newp = pickPosition(og);
        gameBoard.movePiece(og,newp);
    }
    public void gameCycle() {
        int i = 1;
        int t = 0;
        gameBoard.newGame();
        while (!gameBoard.gameOver().equals("continue")) {
            gameBoard.showBoard();
            System.out.println();
            System.out.println("Turn " + i);
            System.out.println();
            String og = pickPiece();
            System.out.println(Board.allMoves(gameBoard.getPiece(og)));
            String newp = pickPosition(og);
            gameBoard.movePiece(og, newp);
            if (t == 1) {
                i++;
                t = 0;
            } else {
                t++;
            }
        }
    }
    public String pickPiece() {
        boolean white = (turnCount % 2 == 1);
        if (white) {
            System.out.println("It is white's turn \nSelect a piece to move\n");
        }
        else {
            System.out.println("It is black's turn \nSelect a piece to move\n");
        }
        boolean valid = false;
        Piece p = new Information("TEMP",0,0);
        String input = null;

        while (!valid) {
            System.out.println();
            gameBoard.showBoard();
            valid = true;
            input = sc.nextLine().trim();

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
            if(tempPiece.possibleMoves().size()==0) {
                System.out.println("That piece cannot move");
                valid = false;
                continue;
            }
            p = tempPiece;
        };

        return input;
    }
    public String pickPosition(String p) {
        boolean valid = false;
        String pos = null;
        Piece pp = gameBoard.getPiece(p);
        System.out.println("\nSelect a place to move that " + pp.getType());
        while (!valid) {
            System.out.println();
            gameBoard.showBoard();
            valid = true;
            pos = sc.nextLine().trim();
            int[] position = gameBoard.boardPosition(pos);
            if (position == null) {
                System.out.println("\nThat is not a valid spot");
                valid = false;
                continue;
            }
            if (!gameBoard.validMove(pp, position)) {
                System.out.println("\nThat is not a valid move");
                valid = false;
                continue;
            }
        }
        return pos;
    }
}
