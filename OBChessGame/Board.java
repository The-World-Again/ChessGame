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
    public boolean canMove(Piece piece) {
        int[] piecePosition = piece.getPose();
        return true;
    }
    public void setBoard() {
        for (int r = 0; r < chessBoard.length; r++) {
            for (int c = 0; c < chessBoard[0].length; c++) {
                chessBoard[r][c] = new Information("   ");
            }
        }
        String[] letters = {"A","B","C","D","E","F","G","H"};
        String[] numbers = {"1","2","3","4","5","6","7","8"};
        for (int r = 0; r < chessBoard.length-1; r++) {
            for (int c = 0; c < chessBoard[0].length; c++) {
                if (c == 0 && r < 8) {
                    chessBoard[r][c] = new Information(letters[r]);
                }
                if ( r == 8 && c > 0) {
                    chessBoard[r][c] = new Information(numbers[c-1]);
                }
            }
        }
        for(int i = 1; i < 8; i++) {
            chessBoard[7][i] = PieceHolder.getPiece("white",i);
        }
        //chessBoard[2][0] = new Pawn("white",2,1,19);
        System.out.println("Board is set");
    }
    public void showBoard() {
        for (Piece[] pieces : chessBoard) {
            System.out.println(Arrays.toString(pieces));
        }
        System.out.println(chessBoard[6][0].possibleMoves());
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
    public static Piece[][] getBoard() {
        return chessBoard;
    }
}
