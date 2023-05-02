import java.util.ArrayList;
import java.util.Arrays;

/**
 * The king
 * @Cameron, Ori
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
        try {
            //Orthogonal movements
            if (pose[0]-2 >= 0 && (board[pose[0]-1][pose[1]].getName().equals("___") ||
                    board[pose[0]-1][pose[1]].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0]-1);
                possibleMoves.add(pose[1]);
            }

            if (board[pose[0]][pose[1]-1].getName().equals("___") ||
                    board[pose[0]][pose[1]-1].getColor().equals(this.otherColor())) {
                possibleMoves.add(pose[0]);
                possibleMoves.add(pose[1]-1);
            }
            if (pose[1]+2 <= 8 &&
                    (board[pose[0]][pose[1]+1].getName().equals("___") ||
                    board[pose[0]][pose[1]+1].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0]);
                possibleMoves.add(pose[1]+1);
            }
            if (board[pose[0]+1][pose[1]].getName().equals("___") ||
                    board[pose[0]+1][pose[1]].getColor().equals(this.otherColor())) {
                possibleMoves.add(pose[0]+1);
                possibleMoves.add(pose[1]);
            }
            //Diagonal movements
            if (pose[0]-2 >= 0 &&
                    (board[pose[0]-1][pose[1]-1].getName().equals("___") ||
                            board[pose[0]-1][pose[1]-1].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0]-1);
                possibleMoves.add(pose[1]-1);
            }
            if (pose[0]-2 >= 0 && pose[1]+2 <= 8 &&
                    (board[pose[0]-1][pose[1]+1].getName().equals("___") ||
                            board[pose[0]-1][pose[1]+1].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0]-1);
                possibleMoves.add(pose[1]+1);
            }
            if (board[pose[0]+1][pose[1]-1].getName().equals("___") ||
                    board[pose[0]+1][pose[1]-1].getColor().equals(this.otherColor())) {
                possibleMoves.add(pose[0]+1);
                possibleMoves.add(pose[1]-1);
            }
            if (pose[1]+2 <= 8 &&
                    (board[pose[0]+1][pose[1]+1].getName().equals("___") ||
                            board[pose[0]+1][pose[1]+1].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0]+1);
                possibleMoves.add(pose[1]+1);
            }

        }
        catch (Exception ignored) {
            System.out.println("ERROR");
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
