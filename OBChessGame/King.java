import java.util.ArrayList;
import java.util.Arrays;

/**
 * The king
 * @Cameron, Ori
 */
public class King extends Piece
{
    /**
     * Constructor for objects of class King
     */
    public King(String c, int y, int x, int nu, int idx)
    {
        super(c,"king", y, x, nu, idx);
    }

    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        Piece[][] board = Board.getBoard();
        int[] pose = this.getPose();
        try {
            //Orthogonal movements
            //Up
            if (pose[0] - 1 >= 0 && (board[pose[0] - 1][pose[1]].getName().equals("___") ||
                    board[pose[0] - 1][pose[1]].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0] - 1);
                possibleMoves.add(pose[1]);
            }
            //Left
            if (board[pose[0]][pose[1] - 1].getName().equals("___") ||
                    board[pose[0]][pose[1] - 1].getColor().equals(this.otherColor())) {
                possibleMoves.add(pose[0]);
                possibleMoves.add(pose[1] - 1);
            }
            //Right
            if (pose[1] + 1 <= 8 &&
                    (board[pose[0]][pose[1] + 1].getName().equals("___") ||
                            board[pose[0]][pose[1] + 1].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0]);
                possibleMoves.add(pose[1] + 1);
            }
            //Down
            if (board[pose[0] + 1][pose[1]].getName().equals("___") ||
                    board[pose[0] + 1][pose[1]].getColor().equals(this.otherColor())) {
                possibleMoves.add(pose[0] + 1);
                possibleMoves.add(pose[1]);
            }
            //Diagonal movements
            //Top left
            if (pose[0] - 1 >= 0 &&
                    (board[pose[0] - 1][pose[1] - 1].getName().equals("___") ||
                            board[pose[0] - 1][pose[1] - 1].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0] - 1);
                possibleMoves.add(pose[1] - 1);
            }
            //Top right
            if (pose[0] - 1 >= 0 && pose[1] + 1 <= 8 &&
                    (board[pose[0] - 1][pose[1] + 1].getName().equals("___") ||
                            board[pose[0] - 1][pose[1] + 1].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0] - 1);
                possibleMoves.add(pose[1] + 1);
            }
            //Bottom left
            if (board[pose[0] + 1][pose[1] - 1].getName().equals("___") ||
                    board[pose[0] + 1][pose[1] - 1].getColor().equals(this.otherColor())) {
                possibleMoves.add(pose[0] + 1);
                possibleMoves.add(pose[1] - 1);
            }
            //Bottom right
            if (pose[1] + 1 <= 8 &&
                    (board[pose[0] + 1][pose[1] + 1].getName().equals("___") ||
                            board[pose[0] + 1][pose[1] + 1].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0] + 1);
                possibleMoves.add(pose[1] + 1);
            }

        } catch (Exception ignored) {
            System.out.println("KING ERROR");
        }


        return possibleMoves;
    }

    @Override
    public String getType() {
        return "king";
    }
    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            return "wk ";
        }
        else return "bk ";
    }
}
