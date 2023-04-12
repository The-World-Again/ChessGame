import java.util.ArrayList;

/**
 * The bishop
 * @Cameron
 */
public class Bishop extends Piece
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Bishop
     */
    public Bishop(String c, int x, int y, int nu)
    {
        super(c,"bishop", x, y, nu);
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
            return "wb"+(this.getNum()+1);
        }
        else return "bb"+(this.getNum()+1);
    }
}
