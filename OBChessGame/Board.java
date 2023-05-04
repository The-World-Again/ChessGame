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
    public void promote() {
        System.out.println("That pawn has become a PLACEHOLDER");
    }
    //Sets up the board for use
    public void setBoard() {
        //Establishes coordinates
        String[] letters = {"A","B","C","D","E","F","G","H"};
        String[] numbers = {"1","2","3","4","5","6","7","8"};
        for (int r = 0; r < chessBoard.length; r++) {
            for (int c = 0; c < chessBoard[0].length; c++) {
                chessBoard[r][c] = new Information("___");
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
        int a = 4;
        int b = 5;
        chessBoard[a][b] = new Queen("black",a,b,5);
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
        if (i <= 7) {
            r = letters[i];
        }
        else {r = "OUTOFBOUNDS";}
        return r;
    }
    //Converts letters into numbers
    public int numberBuilder(String s) {
        String[] letters = {"A","B","C","D","E","F","G","H"};
        for (int i = 0; i < letters.length; i++) {
            if (s.equals(letters[i])) {
                return i;
            }
        }
        return 404;
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
            // Implements the commas between coordinates if necessary
            if(moves.size() == 2) {allMoves += rString.get(0);}
            if(moves.size() == 4) {allMoves += rString.get(0) + " or " + rString.get(1);}
            else {
                for (int idx = 0; idx < rString.size(); idx++) {
                    allMoves += rString.get(idx);
                    if (idx == rString.size() - 2) {
                        allMoves += ", or ";
                    } else if (idx <= rString.size() - 3) {
                        allMoves += ", ";
                    }
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
    //Moves a piece to a new position
    //Assumes that the move and piece are valid selections
    public void movePiece(String ogP, String newP) {
        if(ogP.length() > 2 || newP.length() > 2) {
            System.out.println("That is not a valid position");
            System.out.println();
            return;
        }
        int ogY = 0;
        int ogX = 0;
        int newY = 0;
        int newX = 0;
        try {
            ogY = numberBuilder(ogP.substring(0, 1));
            ogX = Integer.parseInt(ogP.substring(1));
            newY = numberBuilder(newP.substring(0, 1));
            newX = Integer.parseInt(newP.substring(1));
        }
        catch (Exception ignored) {
            System.out.println("That is not a valid position");
            System.out.println();
            return;
        }
        if (ogY == 404 || ogX > 8 || newY == 404 || newX > 8) {
            System.out.println("That is not a valid position");
            System.out.println();
            return;
        }
        Piece c = chessBoard[ogY][ogX];
        System.out.println(c);
        chessBoard[4][5] = new Information("___");
        chessBoard[newY][newX] = c;
        System.out.println();
        System.out.println("The " + c.getName() + " has been moved to " + poseBuilder(newY) + newX);
        System.out.println();
    }
}
