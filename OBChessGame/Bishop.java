import java.util.ArrayList;

/**
 * The bishop
 * @Cameron, Ori
 */
public class Bishop extends Piece
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Bishop
     */
    public Bishop(String c, int y, int x, int nu, int idx)
    {
        super(c,"bishop", y, x, nu, idx);
    }

    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        Piece[][] board = Board.getBoard();
        int[] pose = this.getPose();
        try {
            //Top left
            for (int x = 1; (pose[0]-x <= 0) && (board[pose[0]-x][pose[1]-x].getName().equals("___") ||
                    board[pose[0]-x][pose[1]-x].getColor().equals(this.otherColor())); x++) {
                possibleMoves.add(pose[0]-x);
                possibleMoves.add(pose[1]-x);
                if (board[pose[0]-x][pose[1]-x].getColor().equals(this.otherColor()) ||
                pose[0]-x-1 < 0) {break;}
            }
            //Top right
            for (int x = 1; (pose[0]-x >= 0 && pose[1]+x < 9) && (board[pose[0]-x][pose[1]+x].getName().equals("___") ||
                    board[pose[0]-x][pose[1]+x].getColor().equals(this.otherColor())); x++) {
                possibleMoves.add(pose[0]-x);
                possibleMoves.add(pose[1]+x);
                if (board[pose[0]-x][pose[1]+x].getColor().equals(this.otherColor()) ||
                        pose[0]-x-1 < 0 || pose[1]+x+1 > 8) {break;}
            }
            //Bottom left
            for (int x = 1; board[pose[0]+x][pose[1]-x].getName().equals("___") ||
                    board[pose[0]+x][pose[1]-x].getColor().equals(this.otherColor()); x++) {
                possibleMoves.add(pose[0]+x);
                possibleMoves.add(pose[1]-x);
                if (board[pose[0]+x][pose[1]-x].getColor().equals(this.otherColor()) ||
                pose[0]+x+1 < 0 || pose[1]-x-1 > 8) {break;}
            }
            //Bottom right
            for (int x = 1; pose[1]+x < 9 && (board[pose[0]+x][pose[1]+x].getName().equals("___") ||
                    board[pose[0]+x][pose[1]+x].getColor().equals(this.otherColor())); x++) {
                possibleMoves.add(pose[0]+x);
                possibleMoves.add(pose[1]+x);
                if (board[pose[0]+x][pose[1]+x].getColor().equals(this.otherColor()) ||
                pose[1]+x+1 > 8) {break;}
            }
        }
        catch (Exception ignored) {
            System.out.println("BISHOP ERROR");
        }
        return possibleMoves;
    }
    @Override
    public String getType() {
        return "bishop";
    }
    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            return "wb"+(this.getNum());
        }
        else return "bb"+(this.getNum());
    }
}
