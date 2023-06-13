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
            if (board[pose[0]+x][pose[1]].getName().equals("___") && pose[0]+x >= 0) {
                possibleMoves.add(pose[0]+x);
                possibleMoves.add(pose[1]);
            }
            if(firstMove && board[pose[0]+(2*x)][pose[1]].getName().equals("___") && pose[0]+(2*x) >= 0) {
                possibleMoves.add(pose[0]+(2*x));
                possibleMoves.add(pose[1]);
            }
            if (board[pose[0]+x][pose[1]-x].getColor().equals(this.otherColor()) &&
            pose[0]+x >= 0 && pose[1]-x <= 8) {
                possibleMoves.add(pose[0]+x);
                possibleMoves.add(pose[1]-x);
            }
            if (board[pose[0]+x][pose[1]+x].getColor().equals(this.otherColor()) &&
            pose[0]+x >= 0 && pose[1]-x <= 8) {
                possibleMoves.add(pose[0]+x);
                possibleMoves.add(pose[1]+x);
            }
        }
        catch (Exception ignored) {
           // System.out.println("PAWN ERROR");
        }

        return possibleMoves;
    }
    public void updateFirstMove() {
        firstMove = false;
    }
    @Override
    public String getType() {
        return "pawn";
    }
    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            return "wp"+(this.getNum()+1);
        }
        else return "bp"+(this.getNum()+1);
    }
}
