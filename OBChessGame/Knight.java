import java.util.ArrayList;

/**
 * The knight
 * @Cameron,Ori
 */
public class Knight extends Piece
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Knight
     */
    public Knight(String c, int y, int x, int nu)
    {
        super(c,"knight", y, x, nu);
    }

    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
        Piece[][] board = Board.getBoard();
        int[] pose = this.getPose();
        int y = 1;
        int x = 2;

        for (int i = 1; i < 9; i++) {
            try {
                y = 1;
                x = 2;
                boolean down = false;
                if (i % 2 == 0) {
                    x = 1;
                    y = 2;
                    }
                if (i % 4 > 2 || i % 4 == 0) {
                    x *= -1;
                }
                if (i > 4) {down = true;}
                if (down) {y *= -1;}
                if (board[pose[0]+y][pose[1]+x].getName().equals("   ")) {
                    possibleMoves.add(pose[0]+y);
                    possibleMoves.add(pose[1]+x);
                }
            }
            catch (Exception ignored) {
                System.out.println("ERROR");
            }
        }
        return possibleMoves;
    }
    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            return "wn"+(this.getNum()+1);
        }
        else return "bn"+(this.getNum()+1);
    }
}
