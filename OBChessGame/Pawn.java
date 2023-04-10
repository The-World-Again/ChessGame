
/**
 * The pawn
 * @Ori
 */
public class Pawn extends Piece
{
    /**
     * Constructor for objects of class Pawn
     */
    public Pawn(String c, int x, int y, int nu)
    {
        super(c,"pawn", x, y, nu);
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
