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
    public King(String c, int y, int x, int nu, int idx)
    {
        super(c,"king", y, x, nu, idx);
        inCheck = false;
    }

    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        Piece[][] board = Board.getBoard();
        int[] pose = this.getPose();
        try {
            //Orthogonal movements
            if (pose[0]-1 >= 0 && (board[pose[0]-1][pose[1]].getName().equals("___") ||
                    board[pose[0]-1][pose[1]].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0]-1);
                possibleMoves.add(pose[1]);
            }

            if (board[pose[0]][pose[1]-1].getName().equals("___") ||
                    board[pose[0]][pose[1]-1].getColor().equals(this.otherColor())) {
                possibleMoves.add(pose[0]);
                possibleMoves.add(pose[1]-1);
            }
            if (pose[1]+1 <= 8 &&
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
            if (pose[0]-1 >= 0 &&
                    (board[pose[0]-1][pose[1]-1].getName().equals("___") ||
                            board[pose[0]-1][pose[1]-1].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0]-1);
                possibleMoves.add(pose[1]-1);
            }
            if (pose[0]-1 >= 0 && pose[1]+1 <= 8 &&
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
            if (pose[1]+1 <= 8 &&
                    (board[pose[0]+1][pose[1]+1].getName().equals("___") ||
                            board[pose[0]+1][pose[1]+1].getColor().equals(this.otherColor()))) {
                possibleMoves.add(pose[0]+1);
                possibleMoves.add(pose[1]+1);
            }

        }
        catch (Exception ignored) {
            //System.out.println("KING ERROR");
        }



        return possibleMoves;
    }
    public ArrayList<Integer> availableMoves() {

        ArrayList<Integer> kingMoves = possibleMoves();
        ArrayList<Integer> boardMoves = Board.literallyEveryMove(this);

        for(int i = 0; i < boardMoves.size(); i+= 2) {
            for(int move = 0; move < kingMoves.size(); move+=2) {
                if (kingMoves.get(move).equals(boardMoves.get(i)) &&
                        kingMoves.get(move+1).equals(boardMoves.get(i+1))) {
                    kingMoves.remove(move+1);
                    kingMoves.remove(move);
                    move-=2;
                    //System.out.println("removed move");
                }
            }
        }
        return kingMoves;
    }
    public boolean isInCheck() {
        inCheck = false;
        ArrayList<Integer> boardMoves = Board.literallyEveryMove(this);
        int[] pose = this.getPose();
        for(int i = 0; i < boardMoves.size(); i += 2) {
            int[] move = {boardMoves.get(i),boardMoves.get(i+1)};
            if(pose == move) {inCheck = true; break;}
        }
        return inCheck;
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
