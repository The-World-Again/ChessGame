import java.util.ArrayList;
import java.util.Arrays;

/**
 * Abstract class Piece - Abstract that all game pieces are
 * @Ori
 */
public abstract class Piece
{
    private String color = "";
    private String name = "";
    private int yPose = 0;
    private int xPose = 0;
    private int pieceNumber = 0;
    private int index = 0;
    public Piece (String c, String n, int startingY, int startingX, int nu, int idx) {
        color = c;
        name = n;
        yPose = startingY;
        xPose = startingX;
        pieceNumber = nu;
        index = idx;
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
    public int getIndex() {
        return index;
    }
    public String otherColor() {
        if (this.getColor().equals("white")) {return "black";}
        else if (this.getColor().equals("black")){return "white";}
        else {return "Not a game piece";}
    }
    public void updatePose(int y, int x) {
        yPose = y;
        xPose = x;
    }
    public void flipColor(String c) {
        if (c.equals("white")) {
            color = "black";
        }
        else if (c.equals("black")) {
            color = "white";
        }
        else {
            System.out.println("not a color");
        }
    }
    //This is specifically for pawns
    public void updateFirstMove() {}
    public abstract ArrayList<Integer> possibleMoves();

    public abstract String getType();
    @Override
    public String toString() {
       return name + ", " + color; 
    }
}

