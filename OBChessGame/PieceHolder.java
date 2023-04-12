
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
            whitePieces[i] = new Pawn("white",1,i,pieceNum);
            pieceNum++;
        }
        //rooks
        whitePieces[pieceNum] = new Rook("white",0,0,pieceNum);
        pieceNum++;
        whitePieces[pieceNum] = new Rook("white",0,7,pieceNum);
        pieceNum++;
        //knights
        whitePieces[pieceNum] = new Knight("white",0,1,pieceNum);
        pieceNum++;
        whitePieces[pieceNum] = new Knight("white",0,6,pieceNum);
        pieceNum++;
        //bishop
        whitePieces[pieceNum] = new Bishop("white",0,2,pieceNum);
        pieceNum++;
        whitePieces[pieceNum] = new Bishop("white",0,5,pieceNum);
        pieceNum++;
        //Queen
        whitePieces[pieceNum] = new Queen("white",0,3,pieceNum);
        pieceNum++;
        //King
        whitePieces[pieceNum] = new Bishop("white",7,4,pieceNum);
        pieceNum++;

        pieceNum = 0;
        for (int i = 0; i < 8; i++) {
            blackPieces[i] = new Pawn("black",1,i,pieceNum);
            pieceNum++;
        }
        //rooks
        blackPieces[pieceNum] = new Rook("black",7,0,pieceNum);
        pieceNum++;
        blackPieces[pieceNum] = new Rook("black",7,7,pieceNum);
        pieceNum++;
        //knights
        blackPieces[pieceNum] = new Knight("black",7,1,pieceNum);
        pieceNum++;
        blackPieces[pieceNum] = new Knight("black",7,6,pieceNum);
        pieceNum++;
        //bishop
        blackPieces[pieceNum] = new Bishop("black",7,2,pieceNum);
        pieceNum++;
        blackPieces[pieceNum] = new Bishop("black",7,5,pieceNum);
        pieceNum++;
        //Queen
        blackPieces[pieceNum] = new Queen("black",7,3,pieceNum);
        pieceNum++;
        //King
        whitePieces[pieceNum] = new Bishop("black",7,4,pieceNum);
        pieceNum++;
        System.out.println(whitePieces);
    }
    public Piece[] getWhitePieces(){
        return whitePieces;
    }
    public static Piece getPiece(String color, int i) {
        color = color.toLowerCase();
        if (color.equals("white")) {return whitePieces[i];}
        else if (color.equals("black")) {return blackPieces[i];}
        else {System.out.println("not a color"); return null;}
    }
}
