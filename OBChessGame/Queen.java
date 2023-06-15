import java.util.ArrayList;

/**
 * The queen
 * @Cameron, Ori
 */
public class Queen extends Piece
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Queen
     */
    public Queen(String c, int y, int x, int nu, int idx)
    {
        super(c, "queen", y, x, nu, idx);
    }

    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        Piece[][] board = Board.getBoard();
        int[] pose = this.getPose();
        try {
            //Orthogonal movement
            //Up
            for (int y = 1; board[pose[0]-y][pose[1]].getName().equals("___") ||
                    board[pose[0]-y][pose[1]].getColor().equals(this.otherColor()); y++) {
                possibleMoves.add(pose[0] - y);
                possibleMoves.add(pose[1]);
                if (board[pose[0]-y][pose[1]].getColor().equals(this.otherColor()) ||
                        pose[0]-y-1 < 0) {break;}
            }
            //Left
            for (int x = 1; board[pose[0]][pose[1]-x].getName().equals("___") ||
                    board[pose[0]][pose[1]-x].getColor().equals(this.otherColor()); x++) {
                possibleMoves.add(pose[0]);
                possibleMoves.add(pose[1] - x);
                if(board[pose[0]][pose[1]-x].getColor().equals(this.otherColor())) {break;}
            }
            //Right
            for (int x = 1; pose[1]+x < 9 && (board[pose[0]][pose[1]+x].getName().equals("___") ||
                    board[pose[0]][pose[1]+x].getColor().equals(this.otherColor())); x++) {
                possibleMoves.add(pose[0]);
                possibleMoves.add(pose[1]+x);
                if (board[pose[0]][pose[1]+x].getColor().equals(this.otherColor()) ||
                        pose[1]+x+1 > 8) {break;}
            }
            //Down
            for (int y = 1; board[pose[0]+y][pose[1]].getName().equals("___") ||
                    board[pose[0]+y][pose[1]].getColor().equals(this.otherColor()); y++) {
                possibleMoves.add(pose[0]+y);
                possibleMoves.add(pose[1]);
                if (board[pose[0]+y][pose[1]].getColor().equals(this.otherColor())) {break;}
            }

            //Diagonal movement
            //Top left
            for(int x = 1; board[pose[0]-x][pose[1]-x].getName().equals("___") ||
                    board[pose[0]-x][pose[1]-x].getColor().equals(this.otherColor()); x++) {
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
                if (board[pose[0]+x][pose[1]-x].getColor().equals(this.otherColor())) {break;}
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
            System.out.println("QUEEN ERROR");
        }
        return possibleMoves;
    }
    @Override
    public String getType() {
        return "queen";
    }
    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            if(getNum() > 1) {
                return "wq" + (this.getNum());
            }
            return "wq ";
        }
        else {
            if(getNum()>1) {
                return "bq"+(this.getNum());
            }
            return "bq ";
        }
    }
}
