import java.util.Arrays;

/**
 * The file that handles all the pieces
 * @Ori, Cameron
 */
public class PieceHolder
{
    private static final Piece[] whitePieces = new Piece[16];
    private static final Piece[] blackPieces = new Piece[16];
    public PieceHolder()
    {
        int pieceNum = 0;
        for (int i = 0; i < 8; i++) {
            whitePieces[i] = new Pawn("white",6,i,pieceNum);
            pieceNum++;
        }
        //Sets up the white pieces from left to right
        whitePieces[pieceNum] = new Rook("white",7,1,0);
        pieceNum++;
        whitePieces[pieceNum] = new Knight("white",7,2,0);
        pieceNum++;
        whitePieces[pieceNum] = new Bishop("white",7,3,0);
        pieceNum++;
        whitePieces[pieceNum] = new Queen("white",7,4,0);
        pieceNum++;
        whitePieces[pieceNum] = new King("white",7,5,0);
        pieceNum++;
        whitePieces[pieceNum] = new Bishop("white",7,6,1);
        pieceNum++;
        whitePieces[pieceNum] = new Knight("white",7, 7,1);
        pieceNum++;
        whitePieces[pieceNum] = new Rook("white",7,8,1);

        pieceNum = 0;
        for (int i = 0; i < 8; i++) {
            blackPieces[i] = new Pawn("black",0,i,pieceNum);
            pieceNum++;
        }
        //Sets up the black pieces from left to right
        blackPieces[pieceNum] = new Rook("black",1,1,0);
        pieceNum++;
        blackPieces[pieceNum] = new Knight("black",1,2,0);
        pieceNum++;
        blackPieces[pieceNum] = new Bishop("black",1,3,0);
        pieceNum++;
        blackPieces[pieceNum] = new Queen("black",1,4,0);
        pieceNum++;
        blackPieces[pieceNum] = new King("black",1,5,0);
        pieceNum++;
        blackPieces[pieceNum] = new Bishop("black",1,6,1);
        pieceNum++;
        blackPieces[pieceNum] = new Knight("black",1,7,1);
        pieceNum++;
        blackPieces[pieceNum] = new Rook("black",1,8,1);
        System.out.println(Arrays.toString(whitePieces));
    }
    public Piece[] getWhitePieces() {return whitePieces;}
    public Piece[] getBlackPieces() {return blackPieces;}

    public static Piece getPiece(String color, int i) {
        color = color.toLowerCase();
        if (color.equals("white")) {return whitePieces[i];}
        else if (color.equals("black")) {return blackPieces[i];}
        else {System.out.println("not a color"); return null;}
    }
}
