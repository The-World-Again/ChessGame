import java.util.*;

public class Information extends Piece {
    public Information(String name,int y, int x) {
        super("none",name,y,x,0);
    }
    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> noMoves = new ArrayList<Integer>();
        return noMoves;
    }
    @Override
    public String getType() {
        return "information";
    }
    @Override
    public String toString() {
        return this.getName().toUpperCase();
    }
}
