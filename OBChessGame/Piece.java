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
    public Piece (String c, String n, int startingY, int startingX, int nu) {
        color = c;
        name = n;
        yPose = startingY;
        xPose = startingX;
        pieceNumber = nu;
    }
    /**
     * Returns the current position of the piece
     * NOTE: THE ARRAY IS IN [Y,X] FORMAT
     */
    public int[] getPose() {return new int[] {yPose, xPose};}
    public int getX(){
        return xPose;
    }
    public int getY(){
        return yPose;
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
    public String otherColor() {
        if (this.getColor().equals("white")) {return "black";}
        else if (this.getColor().equals("black")){return "white";}
        else {return "Not a game piece";}
    }
    public abstract ArrayList<Integer> possibleMoves();
    public abstract String getType();
    @Override
    public String toString() {
       return name + ", " + color; 
    }
}

