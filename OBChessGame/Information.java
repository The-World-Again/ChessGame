import java.util.*;

public class Information extends Piece {
    public Information(String name) {
        super("none",name,0,0,0);
    }
    @Override
    public ArrayList<Integer> possibleMoves() {
        ArrayList<Integer> noMoves = new ArrayList<Integer>();
        return noMoves;
    }
    @Override
    public String toString() {
        return this.getName().toUpperCase();
    }
}
