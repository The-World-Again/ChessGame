import java.util.*;

/**
 * The pawn
 * @Ori
 */
public class Pawn extends Piece
{
    boolean firstMove = true;
    /**
     * Constructor for objects of class Pawn
     */
    public Pawn(String c, int y, int x, int nu, int idx)
    {
        super(c,"pawn", y, x, nu, idx);
    }
    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        Piece[][] board = Board.getBoard();
        int[] pose = this.getPose();
        int x = -1;
        if (this.getColor().equals("black")) {x = 1;}
        try {
            //In front
            if ((pose[0]+x >= 0) && board[pose[0]+x][pose[1]].getName().equals("___")) {
                possibleMoves.add(pose[0]+x);
                possibleMoves.add(pose[1]);
            }
            //Double move for first
            if((pose[0]+(2*x) >= 0) && firstMove && board[pose[0]+(2*x)][pose[1]].getName().equals("___")) {
                possibleMoves.add(pose[0]+(2*x));
                possibleMoves.add(pose[1]);
            }
            //Left take
            if ((pose[0]+x >= 0 && pose[1]-x <= 8) && (board[pose[0]+x][pose[1]-x].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0]+x);
                possibleMoves.add(pose[1]-x);
            }
            //Right take
            if ((pose[0]+x >= 0 && pose[1]+x <= 8) && (board[pose[0]+x][pose[1]+x].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0]+x);
                possibleMoves.add(pose[1]+x);
            }
        }
        catch (Exception ignored) {
           System.out.println("PAWN ERROR");
        }

        return possibleMoves;
    }
    public void updateFirstMove() {
        firstMove = !firstMove;
    }
    @Override
    public String getType() {
        return "pawn";
    }
    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            return "wp"+(this.getNum());
        }
        else return "bp"+(this.getNum());
    }
}
