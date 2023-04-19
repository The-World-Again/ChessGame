import java.util.ArrayList;

/**
 * The king
 * @Cameron
 */
public class King extends Piece
{
    // instance variables - replace the example below with your own
    public boolean inCheck;
    /**
     * Constructor for objects of class King
     */
    public King(String c, int y, int x, int nu)
    {
        super(c,"king", y, x, nu);
        inCheck = false;
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
                possibleMoves.add(pose[0]+idx);
                possibleMoves.add(pose[1]);
            }
        }
        catch (Exception e) {
            System.out.println("Exception caught!!!!!");
            System.out.println(e);
        }
        return possibleMoves;
    }
    public boolean isInCheck(){
        return inCheck;
}
    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            return "wk ";
        }
        else return "bk ";
    }
}
