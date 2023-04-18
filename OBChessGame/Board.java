/**
 * Chess board for chess
 * @Ori
 */
import java.util.*;
public class Board
{
    static Piece[][] chessBoard = new Piece[9][9];
    PieceHolder pieceHolder = new PieceHolder();
    boolean white = true;

    public void newGame() {
        setBoard();
        showBoard();
    }

    public void setBoard() {
        String[] letters = {"A","B","C","D","E","F","G","H"};
        String[] numbers = {"1","2","3","4","5","6","7","8"};
        for (int r = 0; r < chessBoard.length; r++) {
            for (int c = 0; c < chessBoard[0].length; c++) {
                chessBoard[r][c] = new Information("   ");
                if (c == 0 && r < 8) {chessBoard[r][c] = new Information(letters[r]);}
                if ( r == 8 && c > 0) {chessBoard[r][c] = new Information(numbers[c-1]+"  ");}
                if (r == 8 && c == 0) {chessBoard[r][c] = new Information(" ");}
            }
        }
        for(int i = 1; i < 9; i++) {
            chessBoard[6][i] = PieceHolder.getPiece("white",i-1);
            chessBoard[7][i] = PieceHolder.getPiece("white",i+7);
            chessBoard[0][i] = PieceHolder.getPiece("black",i-1);
            chessBoard[1][i] = PieceHolder.getPiece("black",i+7);
        }
    }

    public void showBoard() {
        chessBoard[4][3] = new Rook("black",4,3,5);
        for (Piece[] pieces : chessBoard) {
            System.out.println(Arrays.toString(pieces));
        }
        System.out.println();
        System.out.println(chessBoard[4][3].possibleMoves());
        //System.out.println(allMoves(chessBoard[4][3]));
        System.out.println();
    }
    public String poseBuilder(int i) {
        String[] letters = {"A","B","C","D","E","F","G","H"};
        String r = "";
        if (i < 7) {
            r = letters[i];
        }
        else {r = "ERROR";}
        return r;
    }
    public static Piece[][] getBoard() {
        return chessBoard;
    }
    public String allMoves(Piece p) {
        String allMoves = "";

        String tempLetter = "";
        ArrayList<String> letters = new ArrayList<String>();
        ArrayList<Integer> moves = p.possibleMoves();
        for (int i = 1; i < moves.size() + 1; i++) {
            if (i % 2 != 0) {
                tempLetter = poseBuilder(moves.get(i - 1));
            } else {
                letters.add(tempLetter + moves.get(i - 1));
                tempLetter = "";
            }
        }
        System.out.println();
        if (letters.size() == 0) {
            return "This piece has no moves";
        }
        else {
            ArrayList<String> rString = new ArrayList<String>();
            rString.add(letters.get(0));

            for (int i = 1; i < letters.size(); i++) {
                boolean added = false;
                for (int d = 0; d < rString.size(); d++) {
                    if (rString.get(d).substring(0,1).compareTo(letters.get(i).substring(0,1)) >= 0) {
                        rString.add(d,letters.get(i));
                        added = true;
                        break;
                    }
                }
                if (!added) {rString.add(letters.get(i));}
            }
            System.out.println(rString);
            for (int idx = 0; idx < rString.size(); idx++) {
                allMoves += rString.get(idx);
                if (idx == rString.size() - 2) {
                    allMoves += ", or ";
                } else if (idx <= rString.size() - 3) {
                    allMoves += ", ";
                }
            }
            System.out.println("");
        }
        return "This piece can go to " + allMoves;
    }
    public boolean canMove(Piece piece) {
        return !allMoves(piece).equals("This piece has no moves");
    }
}
