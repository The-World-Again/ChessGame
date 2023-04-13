/**
 * Chess board for chess
 * @Ori
 */
import java.util.*;
public class Board
{
    static Piece[][] chessBoard = new Piece[9][9];
    PieceHolder pieceHolder = new PieceHolder();
    boolean white = true;

    public void newGame() {
        setBoard();
        showBoard();
    }

    public void setBoard() {
        String[] letters = {"A","B","C","D","E","F","G","H"};
        String[] numbers = {"1","2","3","4","5","6","7","8"};
        for (int r = 0; r < chessBoard.length; r++) {
            for (int c = 0; c < chessBoard[0].length; c++) {
                chessBoard[r][c] = new Information("   ");
                if (c == 0 && r < 8) {chessBoard[r][c] = new Information(letters[r]);}
                if ( r == 8 && c > 0) {chessBoard[r][c] = new Information(numbers[c-1]+"  ");}
                if (r == 8 && c == 0) {chessBoard[r][c] = new Information(" ");}
            }
        }
        for(int i = 1; i < 9; i++) {
            chessBoard[6][i] = PieceHolder.getPiece("white",i-1);
            chessBoard[7][i] = PieceHolder.getPiece("white",i+7);
            chessBoard[0][i] = PieceHolder.getPiece("black",i-1);
            chessBoard[1][i] = PieceHolder.getPiece("black",i+7);
        }
        System.out.println("Board is set");
    }
    public void showBoard() {
        for (Piece[] pieces : chessBoard) {
            System.out.println(Arrays.toString(pieces));
        }
        System.out.println(chessBoard[6][0].possibleMoves());
    }
    public static Piece[][] getBoard() {
        return chessBoard;
    }
    public String possibleMoves(Piece p) {
        int[] pose = p.getPose();
        String allMoves = "";
        ArrayList<Integer> moves = p.possibleMoves();
        for (int i = 1; i < moves.size() + 1; i++) {
            if (i % 2 == 0) {
                allMoves += "(";
                if (i % 2 != 0) {
                    allMoves += ")";
                }
                allMoves += moves.get(i - 1) + ",";
            }
        }
        if (allMoves.length() == 0) {
            return "This piece has no moves";
        }
        return allMoves;
    }
    public boolean canMove(Piece piece) {
        return !possibleMoves(piece).equals("This piece has no moves");
    }
}
