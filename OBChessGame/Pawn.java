import java.util.*;

/**
 * The pawn
 * @Ori
 */
public class Pawn extends Piece
{
    boolean firstMove = false;
    /**
     * Constructor for objects of class Pawn
     */
    public Pawn(String c, int y, int x, int nu)
    {
        super(c,"pawn", y, x, nu);
    }
    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        Piece[][] board = Board.getBoard();
        int[] pose = this.getPose();
        int idx = -1;
        if (this.getColor().equals("black")) {idx = 1;}
        try {
            if (board[pose[0]][pose[1]+idx] == null) {
                possibleMoves.add(pose[0]+idx);
                possibleMoves.add(pose[1]);
            }
        }
        catch (Exception ignored) {
        }

        return possibleMoves;
    }
    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            return "wp"+(this.getNum()+1);
        }
        else return "bp"+(this.getNum()+1);
    }
}
