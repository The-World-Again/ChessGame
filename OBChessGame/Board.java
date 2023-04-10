
/**
 * Chess board for chess
 * @Ori
 */
import java.util.*;
public class Board
{
    static Piece[][] chessBoard = new Piece[8][8];
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
                chessBoard[r][c] = null;
            }
        }
        for(int i = 0; i < 8; i++) {
            chessBoard[1][i] = PieceHolder.getPiece("white",i);
        }
        chessBoard[2][0] = new Pawn("white",2,1,19);
        System.out.println("Board is set");
    }
    public void showBoard() {
        for (int i = 0; i < 8; i++) {
            System.out.println(java.util.Arrays.toString(chessBoard[i]));
        }
        System.out.println(chessBoard[1][0].canMove());
    }
    public static Piece[][] getBoard() {
        return chessBoard;
    }
}
