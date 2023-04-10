
/**
 * The file that handles all the pieces
 * @Ori
 */
public class PieceHolder
{
    static Piece[] whitePieces = new Piece[16];
    static Piece[] blackPieces = new Piece[16];
    public PieceHolder()
    {
        int pieceNum = 0;
        for (int i = 0; i < 8; i++) {
            whitePieces[i] = new Pawn("white",7,i,pieceNum);
            pieceNum++;
        }
        
        pieceNum = 0;
        for (int i = 0; i < 8; i++) {
            blackPieces[i] = new Pawn("black",1,i,pieceNum);
            pieceNum++;
        }
    }
    public static Piece getPiece(String color, int i) {
        if (color.toLowerCase().equals("white")) {return whitePieces[i];}
        else if (color.toLowerCase().equals("black")) {return blackPieces[i];}
        else {System.out.println("not a color"); return null;}
    }
}
