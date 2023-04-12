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
    public Pawn(String c, int x, int y, int nu)
    {
        super(c,"pawn", x, y, nu);
    }
    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        Piece[][] board = Board.getBoard();
        int[] pose = this.getPose();
        int idx = -1;
        if (this.getColor().equals("black")) {idx = 1;}
        try {
            if (board[pose[1]+idx][pose[0]] == null) {
                possibleMoves.add(pose[1]+idx);
                possibleMoves.add(pose[0]);
            }
        }
        catch (Exception e) {
            System.out.println("Exception caught!!!!!");
            System.out.println(e);
        }
        if (possibleMoves.size() == 0) {
            System.out.println("No possible moves for the pawn");
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
