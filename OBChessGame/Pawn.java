import java.util.*;

/**
 * The pawn
 * @Ori
 */
public class Pawn extends Piece
{
    boolean firstMove = false;
    /**
     * Constructor for objects of class Pawn
     */
    public Pawn(String c, int y, int x, int nu)
    {
        super(c,"pawn", y, x, nu);
    }
    private static int totalPromotions = 0;
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
            System.out.println("ERROR");
        }

        return possibleMoves;
    }
    public static void incrementPromotions() {
        totalPromotions++;
    }
    public static int getPromotions() {
        return totalPromotions;
    }
    public Piece promote(String s) {
        s = s.toLowerCase().strip();
        if(s.charAt(s.length() - 2) == '.') {s = s.substring(0,s.length()-2);}
        if (s.equals("knight")) {return null;}
        else return null;
    }
    @Override
    public String getType() {
        return "piece";
    }
    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            return "wp"+(this.getNum()+1);
        }
        else return "bp"+(this.getNum()+1);
    }
}
