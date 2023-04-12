
/**
 * The queen
 * @Cameron
 */
public class Queen extends Piece
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Queen
     */
    public Queen(String c, int x, int y, int nu)
    {
        super(c, "queen", x, y, nu);
    }

    @Override
    public boolean canMove() {
        Piece[][] board = Board.getBoard();
        int[] pose = this.getPose();
        int idx = -1;
        if (this.getColor().equals("black")) {idx = 1;}
        try {
            return board[pose[1]+idx][pose[0]] == null;
        }
        catch (Exception e) {
            System.out.println("Exception caught!!!!!");
            return false;
        }
    }
    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            return "wp"+(this.getNum()+1);
        }
        else return "bp"+(this.getNum()+1);
    }
}
