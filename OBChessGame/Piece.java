import java.util.ArrayList;

/**
 * Abstract class Piece - Abstract that all game pieces are
 * @Ori
 */
public abstract class Piece
{
    private String color = "";
    private String name = "";
    private int xPose = 0;
    private int yPose = 0;
    private int pieceNumber = 0;
    public Piece (String c, String n, int startingX, int startingY, int nu) {
        color = c;
        name = n;
        xPose = startingX;
        yPose = startingY;
        pieceNumber = nu;
    }
    /**
     * Returns the current position of the piece
     */
    public int[] getPose()
    {
        int[] pose = {xPose, yPose};
        return pose;
    }
    public int getNum() {
        return pieceNumber;
    }
    public String getName() {
        return name.toLowerCase();
    }
    public String getColor() {
        return color.toLowerCase();
    }
    public abstract ArrayList<Integer> possibleMoves();
    @Override
    public String toString() {
       return name + ", " + color; 
    }
}

