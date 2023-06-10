/**
 * The file that handles all the pieces
 * @Ori,Cameron
 */
public class PieceHolder
{
    private static final Piece[] whitePieces = new Piece[16];
    private static final Piece[] blackPieces = new Piece[16];
    public PieceHolder()
    {
        int pieceNum = 0;
        for (int i = 0; i < 8; i++) {
            whitePieces[i] = new Pawn("white",6,i,pieceNum,i);
            pieceNum++;
        }
        //Sets up the white pieces from left to right
        whitePieces[pieceNum] = new Rook("white",7,1,0,8);
        pieceNum++;
        whitePieces[pieceNum] = new Knight("white",7,2,0,9);
        pieceNum++;
        whitePieces[pieceNum] = new Bishop("white",7,3,0,10);
        pieceNum++;
        whitePieces[pieceNum] = new Queen("white",7,4,0,11);
        pieceNum++;
        whitePieces[pieceNum] = new King("white",7,5,0,12);
        pieceNum++;
        whitePieces[pieceNum] = new Bishop("white",7,6,1,13);
        pieceNum++;
        whitePieces[pieceNum] = new Knight("white",7, 7,1,14);
        pieceNum++;
        whitePieces[pieceNum] = new Rook("white",7,8,1,15);
        pieceNum = 0;
        for (int i = 0; i < 8; i++) {
            blackPieces[i] = new Pawn("black",0,i,pieceNum,i);
            pieceNum++;
        }
        //Sets up the black pieces from left to right
        blackPieces[pieceNum] = new Rook("black",0,1,0,8);
        pieceNum++;
        blackPieces[pieceNum] = new Knight("black",0,2,0,9);
        pieceNum++;
        blackPieces[pieceNum] = new Bishop("black",0,3,0,10);
        pieceNum++;
        blackPieces[pieceNum] = new Queen("black",0,4,0,11);
        pieceNum++;
        blackPieces[pieceNum] = new King("black",0,5,0,12);
        pieceNum++;
        blackPieces[pieceNum] = new Bishop("black",0,6,1,13);
        pieceNum++;
        blackPieces[pieceNum] = new Knight("black",0,7,1,14);
        pieceNum++;
        blackPieces[pieceNum] = new Rook("black",0,8,1,15);
        //System.out.println(Arrays.toString(whitePieces));
    }

    public static Piece getPiece(String color, int i) {
        color = color.toLowerCase();
        if (color.equals("white")) {return whitePieces[i];}
        else if (color.equals("black")) {return blackPieces[i];}
        else {System.out.println("not a color"); return null;}
    }
    public static Piece getPiece(String name) {
        int[] pose = Board.findPiece(name);
        assert pose != null;
        return Board.getPiece(pose);
    }
    public static void updatePosition(String color, int idx,int y,int x) {
        boolean white = color.toLowerCase().trim().equals("white");
        if (white) {
            whitePieces[idx].updatePose(y,x);
        }
        else {
            whitePieces[idx].updatePose(y,x);
        }
    }
    public static void setPiece(String color, String pieceName, int i) {
        color = color.toLowerCase();
        pieceName = pieceName.toLowerCase();
        Piece p;
        if (color.equals("white")) {
            p = whitePieces[i];
            if (pieceName.equals("knight")) {p = new Knight(color,whitePieces[i].getY(),whitePieces[i].getX(),whitePieces[i].getNum(),whitePieces[i].getIndex());}
            if (pieceName.equals("bishop")) {p = new Bishop(color,whitePieces[i].getY(),whitePieces[i].getX(),whitePieces[i].getNum(),whitePieces[i].getIndex());}
            if (pieceName.equals("rook")) {p = new Rook(color,whitePieces[i].getY(),whitePieces[i].getX(),whitePieces[i].getNum(),whitePieces[i].getIndex());}
            if (pieceName.equals("queen")) {p = new Queen(color,whitePieces[i].getY(),whitePieces[i].getX(),whitePieces[i].getNum(),whitePieces[i].getIndex());}
            whitePieces[i] = p;
        }
        else {
            p = blackPieces[i];
            if (pieceName.equals("knight")) {p = new Knight(color,blackPieces[i].getY(),blackPieces[i].getX(),blackPieces[i].getNum(),blackPieces[i].getIndex());}
            if (pieceName.equals("bishop")) {p = new Bishop(color,blackPieces[i].getY(),blackPieces[i].getX(),blackPieces[i].getNum(),blackPieces[i].getIndex());}
            if (pieceName.equals("rook")) {p = new Rook(color,blackPieces[i].getY(),blackPieces[i].getX(),blackPieces[i].getNum(),blackPieces[i].getIndex());}
            if (pieceName.equals("queen")) {p = new Queen(color,blackPieces[i].getY(),blackPieces[i].getX(),blackPieces[i].getNum(),blackPieces[i].getIndex());}
        }
        blackPieces[i] = p;
    }
}
