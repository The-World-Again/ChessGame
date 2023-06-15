import java.util.Arrays;
import java.util.Scanner;
public class GameHandler {
    static Scanner sc = new Scanner(System.in);
    static int turnCount = 1;
    static int playerTurn = 0;
    static int[] score = {0,0};
    Board gameBoard = new Board();
    public void testGame() {
        gameBoard.newGame();
        System.out.println();
        gameBoard.movePiece("wq","d8");
        gameBoard.movePiece("bp7","C7");
        System.out.println(Board.allMoves(Board.findPiece("wq")));
        System.out.println(gameBoard.gameOver());
    }
    public void gameCycle() {
        turnCount = 1;
        playerTurn = 0;
        gameBoard.newGame();
        while (gameBoard.gameOver().equals("continue")) {
            System.out.println("Turn " + turnCount + ": ");
            System.out.println();
            String og = pickPiece();
            if(Board.findPiece(og)!=null) {
                System.out.println(Board.allMoves(Board.findPiece(og)));
            }
            else {
                System.out.println(Board.allMoves(gameBoard.getPiece(og)));
            }
            String newp = pickPosition(og);
            gameBoard.movePiece(og, newp);
            if (playerTurn == 1) {
                turnCount++;
                playerTurn = 0;
            } else {
                playerTurn++;
            }
        }
        if(gameBoard.gameOver().equals("w")) {
            System.out.println("White wins!");
            score[0]++;
        }
        else if (gameBoard.gameOver().equals("b")) {
            System.out.println("Black wins!");
            score[1]++;
        }
        System.out.println("Play again?\nY/N");
        System.out.println();
        while (!sc.nextLine().toLowerCase().equals("y") || !sc.nextLine().toLowerCase().equals("n")) {
            System.out.println("Play again?\nY/N");
            System.out.println();
        }
        if (sc.nextLine().toLowerCase().equals("y")) {
            gameCycle();
        }
    }
    public String pickPiece() {
        boolean white = (playerTurn % 2 == 0);
        if (white) {
            System.out.println("It is white's turn \nSelect a piece to move");
        }
        else {
            System.out.println("It is black's turn \nSelect a piece to move");
        }
        boolean valid = false;
        Piece p = new Information("TEMP",0,0);
        String input = null;

        while (!valid) {
            System.out.println();
            gameBoard.showBoard();
            valid = true;
            input = sc.nextLine().trim();

            if(Board.findPiece(input)!=null) {
                p = Board.findPiece(input);
            }
            else {
                if (input.length() != 2) {
                    System.out.println("That is not a valid position");
                    valid = false;
                    continue;
                }

                p = gameBoard.getPiece(input);
            }
            if (p == null || p.getType().equals("information")) {
                System.out.println("That is not a valid piece");
                valid = false;
                continue;
            }


            if(white) {
                if (!(p.getColor().equals("white"))) {
                    System.out.println("That is not one of your pieces");
                    valid = false;
                    continue;
                }
            }
            else {
                if(!(p.getColor().equals("black"))) {
                    System.out.println("That is not one of your pieces");
                    valid = false;
                    continue;
                }
            }
            if(!gameBoard.canMove(p)) {
                System.out.println("That piece cannot move");
                valid = false;
                continue;
            }
            p = p;
        }

        return input;
    }
    public String pickPosition(String p) {
        boolean valid = false;
        String pos = null;
        Piece pp = null;
        if (Board.findPiece(p) != null) {
            pp = Board.findPiece(p);
        }
        else {
            pp = gameBoard.getPiece(p);
        }
        System.out.println("\nSelect a place to move that " + pp.getType());
        while (!valid) {
            gameBoard.showBoard();
            valid = true;
            pos = sc.nextLine().trim();
            int[] position = gameBoard.boardPosition(pos);
            if (position == null) {
                System.out.println("\nThat is not a valid spot");
                valid = false;
                System.out.println();
                continue;
            }
            if (!gameBoard.validMove(pp, pos)) {
                System.out.println("\nThat is not a valid move");
                valid = false;
                System.out.println();
                continue;
            }
        }
        return pos;
    }
}
