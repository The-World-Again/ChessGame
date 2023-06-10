import java.util.*;

public class Information extends Piece {
    public Information(String name,int y, int x) {
        super("none",name,y,x,-1, -1);
    }
    @Override
    public ArrayList<Integer> possibleMoves() {
        return new ArrayList<Integer>();
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
