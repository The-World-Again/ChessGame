/**
 * Chess board for chess
 * @Ori
 */
import java.util.*;
public class Board
{
    //2D array representing the board
    static Piece[][] chessBoard = new Piece[9][9];
    //Holds all game pieces for each color
    PieceHolder pieceHolder = new PieceHolder();

    public void newGame() {
        setBoard();
        showBoard();
    }
    //Sets up the board for use
    public void setBoard() {
        //Establishes coordinates
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
        //Sets up all pieces
        for(int i = 1; i < 9; i++) {
            chessBoard[6][i] = PieceHolder.getPiece("white",i-1);
            chessBoard[7][i] = PieceHolder.getPiece("white",i+7);
            chessBoard[1][i] = PieceHolder.getPiece("black",i-1);
            chessBoard[0][i] = PieceHolder.getPiece("black",i+7);
        }
    }
    //Shows the board in its current state
    public void showBoard() {
        int a = 7;
        int b = 5;
        chessBoard[a][b] = new King("black",a,b,5);
        for (Piece[] pieces : chessBoard) {
            System.out.println(Arrays.toString(pieces));
        }
        //System.out.println(chessBoard[a][b].possibleMoves());
        System.out.println(allMoves(chessBoard[a][b]));
    }
    //Converts a number into its related letter
    public String poseBuilder(int i) {
        String[] letters = {"A","B","C","D","E","F","G","H"};
        String r = "";
        if (i < 7) {
            r = letters[i];
        }
        else {r = "OUTOFBOUNDS";}
        return r;
    }
    //Gets the board
    public static Piece[][] getBoard() {
        return chessBoard;
    }
    //Returns the string for the player to see all possible plays
    public String allMoves(Piece p) {
        System.out.println("");

        String allMoves = "";
        // Sets up the coordinates gotten from a pieces possible moves
        // The first number of each pair is turned into a letter, then is concatenated with the second number
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
        if (letters.size() == 0) {
            return "There are no possible moves for the " + p.getName();
        }
        else {
            ArrayList<String> rString = new ArrayList<String>();
            rString.add(letters.get(0));

            // This organizes the coordinates top to bottom, left to right
            for (int i = 1; i < letters.size(); i++) {
                boolean added = false;
                for (int d = 0; d < rString.size(); d++) {
                    // Checks to see where the letter should be added
                    if(rString.get(d).equals(letters.get(i))) {
                        break;
                    }
                    else if (rString.get(d).substring(0,1).compareTo(letters.get(i).substring(0,1)) > 0) {
                        rString.add(d,letters.get(i));
                        added = true;
                        break;
                    }
                    // If the letters are the same, this checks where to add the number
                    else if (rString.get(d).substring(0,1).compareTo(letters.get(i).substring(0,1)) == 0) {
                        if (rString.get(d).substring(1).compareTo(letters.get(i).substring(1)) > 0) {
                            rString.add(d,letters.get(i));
                            added = true;
                            break;
                        }
                    }
                }
                if (!added) {rString.add(letters.get(i));}
            }
            // Implements the commas between coordinates
            for (int idx = 0; idx < rString.size(); idx++) {
                allMoves += rString.get(idx);
                if (idx == rString.size() - 2) {
                    allMoves += ", or ";
                } else if (idx <= rString.size() - 3) {
                    allMoves += ", ";
                }
            }
        }
        return "The " + p.getName() + " can go to " + allMoves;
    }
    public boolean canMove(Piece piece) {
        String a = allMoves(piece);
        a = a.substring(0,27);
        return !a.equals("There are no possible moves");
    }
}
