import java.util.ArrayList;

/**
 * The rook
 * @Cameron
 */
public class Rook extends Piece
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Rook
     */
    public Rook(String c, int y, int x, int nu)
    {
        super(c,"rook", y, x, nu);
    }

    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        Piece[][] board = Board.getBoard();
        int[] pose = this.getPose();
        try {
            for (int y = 1; board[pose[0]-y][pose[1]].getName().equals("   "); y++) {
                possibleMoves.add(pose[0] - y);
                possibleMoves.add(pose[1]);
                if (pose[0]-y-1 < 0) {break;}
            }
            for (int x = 1; board[pose[0]][pose[1]-x].getName().equals("   "); x++) {
                possibleMoves.add(pose[0]);
                possibleMoves.add(pose[1] - x);
            }
            for (int x = 1; board[pose[0]][pose[1]+x].getName().equals("   "); x++) {
                possibleMoves.add(pose[0]);
                possibleMoves.add(pose[1]+x);
                if (pose[1]+x+1 > 8) {break;}
            }
            for (int y = 1; board[pose[0]+y][pose[1]].getName().equals("   "); y++) {
                possibleMoves.add(pose[0]+y);
                possibleMoves.add(pose[1]);
            }
        }
        catch (Exception ignored) {
            System.out.println("ERROR");
        }
        return possibleMoves;
    }

    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            return "wr"+(this.getNum()+1);
        }
        else return "br"+(this.getNum()+1);
    }
}
