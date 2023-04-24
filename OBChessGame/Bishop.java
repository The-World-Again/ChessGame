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
    public Bishop(String c, int y, int x, int nu)
    {
        super(c,"bishop", y, x, nu);
    }

    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        Piece[][] board = Board.getBoard();
        int[] pose = this.getPose();
        try {
            for(int x = 1; board[pose[0]-x][pose[1]-x].getName().equals("   "); x++) {
                possibleMoves.add(pose[0]-x);
                possibleMoves.add(pose[1]-x);
                if (pose[0]-x-1 < 0) {break;}
            }
            for (int x = 1; board[pose[0]-x][pose[1]+x].getName().equals("   ") ; x++) {
                possibleMoves.add(pose[0]-x);
                possibleMoves.add(pose[1]+x);
                if (pose[0]-x-1 < 0 || pose[1]+x+1 > 8) {break;}
            }
            for (int x = 1; board[pose[0]+x][pose[1]-x].getName().equals("   ") ; x++) {
                possibleMoves.add(pose[0]+x);
                possibleMoves.add(pose[1]-x);
            }
            for (int x = 1; board[pose[0]+x][pose[1]+x].getName().equals("   ") ; x++) {
                possibleMoves.add(pose[0]+x);
                possibleMoves.add(pose[1]+x);
                if (pose[1]+x+1 > 8) {break;}
            }
        }
        catch (Exception ignored) { }
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
