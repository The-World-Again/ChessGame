/**
 * Chess board for chess
 * @Ori
 */
import java.util.*;
import java.util.Scanner;
public class Board
{
    //2D array representing the board
    static Piece[][] chessBoard = new Piece[9][9];
    static Scanner sc = new Scanner(System.in);
    //Holds the number to give a piece
    //Organized in order of knight, bishop, rook, queen
    private static int[] promoteCounter = {2,2,2,1};
    //Holds all game pieces for each color
    public void newGame() {
        setBoard();
        //showBoard();
    }
    PieceHolder pieceHolder = new PieceHolder();
    //Sets up the board for use
    public void setBoard() {
        //Establishes coordinates
        String[] letters = {"A","B","C","D","E","F","G","H"};
        String[] numbers = {"1","2","3","4","5","6","7","8"};
        for (int r = 0; r < chessBoard.length; r++) {
            for (int c = 0; c < chessBoard[0].length; c++) {
                chessBoard[r][c] = new Information("___",r,c);
                if (c == 0 && r < 8) {chessBoard[r][c] = new Information(letters[r],r,c);}
                if ( r == 8 && c > 0) {chessBoard[r][c] = new Information(numbers[c-1]+"  ",r,c);}
                if (r == 8 && c == 0) {chessBoard[r][c] = new Information(" ",r,c);}
            }
        }
        //Sets up all pieces
        for(int i = 1; i < 9; i++) {
            chessBoard[6][i] = PieceHolder.retrievePiece("white",i-1);
            chessBoard[7][i] = PieceHolder.retrievePiece("white",i+7);
            chessBoard[1][i] = PieceHolder.retrievePiece("black",i-1);
            chessBoard[0][i] = PieceHolder.retrievePiece("black",i+7);
        }
    }
    //Shows the board in its current state
    public void showBoard() {
        for (Piece[] pieces : chessBoard) {
            System.out.println(Arrays.toString(pieces));
        }
    }
    public static void checkPiece(int y, int x) {
        chessBoard[y][x] = new Queen("black",y,x,5,-1);
        //System.out.println(chessBoard[a][b].possibleMoves());
        System.out.println(allMoves(chessBoard[y][x]));
    }
    //Converts a number into its related letter
    public static String poseBuilder(int i) {
        String[] letters = {"A","B","C","D","E","F","G","H"};
        String r = "";
        if (i <= 7) {
            r = letters[i];
        }
        else {r = "OUTOFBOUNDS";}
        return r;
    }
    //Converts letters into numbers
    public static int numberBuilder(String s) {
        s = s.toUpperCase();
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
    public static String allMoves(Piece p) {
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
            else if(moves.size() == 4) {allMoves += rString.get(0) + " or " + rString.get(1);}
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
        return "The " + p.getColor() + " " + p.getName() + " can go to " + allMoves;
    }
    public static ArrayList<Integer> literallyEveryMove(Piece picked) {
        ArrayList<Integer> moveHolder = new ArrayList<Integer>();
        for (Piece[] pieces : chessBoard) {
            for (Piece p : pieces) {
                if (p.getType().equals("information")|| p.getColor().equals(picked.getColor()) || p.equals(picked)) {
                    //System.out.println("skipped");
                    continue;
                }
                moveHolder.addAll(p.possibleMoves());
                //System.out.println(p.toString());
            }
        }
        return moveHolder;
    }
    public boolean canMove(Piece piece) {
        String a = allMoves(piece);
        a = a.substring(0,27);
        return !a.equals("There are no possible moves");
    }
    //Gets a piece at a specific position
    public Piece getPiece(String position) {
        if (boardPosition(position) == null) {
            return null;
        }
        return chessBoard[boardPosition(position)[0]][boardPosition(position)[1]];
    }
    public static Piece getPiece(int[] pose) {
        if((pose[0] < 0 || pose[0] > 7) || (pose[1] < 1 || pose[1] > 8)) {
            return null;
        }
        return chessBoard[pose[0]][pose[1]];
    }
    //Finds a requested piece
    public static Piece findPiece(String name) {
        name = name.toLowerCase().trim();
        for(Piece[] pieces : chessBoard) {
            for(Piece p : pieces) {
                if (p.toString().trim().equals(name)) {
                    return p;
                }
            }
        }
        return null;
    }
    public int[] boardPosition(String s) {
        s = s.trim();
        if (s.length() > 2) {
            return null;
        }
        int y = -1;
        int x = -1;
        try {
            y = numberBuilder(s.substring(0, 1));
            x = Integer.parseInt(s.substring(1));
        }
        catch (Exception ignored) {
            return null;
        }
        if (y == 404 || (x > 8 || x < 1)) {
            return null;
        }
        return new int[]{y,x};
    }
    public boolean validMove(Piece p, String s) {
        int[] pos = boardPosition(s);
        ArrayList<Integer> moves = p.possibleMoves();
        for(int i = 0; i < p.possibleMoves().size();i += 2) {
            assert pos != null;
            if(moves.get(i).equals(pos[0]) && moves.get(i+1).equals(pos[1])) {
                return true;
            }
        }
        return false;
    }

    public boolean validMove(Piece p, int[] pos) {
        ArrayList<Integer> moves = p.possibleMoves();
        for(int i = 0; i < p.possibleMoves().size();i += 2) {
            assert pos != null;
            if(moves.get(i).equals(pos[0]) && moves.get(i+1).equals(pos[1])) {
                return true;
            }
        }
        return false;
    }

    //Moves a piece to a new position
    //Checks if the words are the right size and fit on the board
    public void movePiece(String ogPos, String newPos) {
        Piece p = null;
        if (findPiece(ogPos) != null) {
            p = findPiece(ogPos);
        }
        else {
            p = getPiece(ogPos);
        }
        int[] position = boardPosition(newPos);
        chessBoard[p.getY()][p.getX()] = new Information("___", p.getY(), p.getX());
        chessBoard[position[0]][position[1]] = p;
        PieceHolder.updatePosition(p.getColor(),p.getIndex(),position[0],position[1]);
        p.updateFirstMove();
        System.out.println();
        System.out.println("The " + p.getColor() + " " + p.getName() + " has been moved to " + poseBuilder(position[0]) + position[1]);
        System.out.println();
        showBoard();
        System.out.println();
    }
    public static void movePiece(int[] ogPos, int[] position) {
        Piece p = chessBoard[ogPos[0]][ogPos[1]];
        chessBoard[p.getY()][p.getX()] = new Information("___", p.getY(), p.getX());
        chessBoard[position[0]][position[1]] = p;
        PieceHolder.updatePosition(p.getColor(),p.getIndex(),position[0],position[1]);
        p.updateFirstMove();
        System.out.println();
        System.out.println("The " + p.getColor() + " " + p.getName() + " has been moved to " + poseBuilder(position[0]) + position[1]);
        System.out.println();
    }
    public int[] checkPromotions() {
        for(Piece[] pieces : chessBoard) {
            for(Piece p : pieces) {
                if(p.getType().equals("pawn")) {
                    if((p.getColor().equals("white") && p.getY()==0) ||
                            p.getColor().equals("black") && p.getY()==7) {
                        return p.getPose();
                    }
                }
            }
        }
        return null;
    }
    public void promote(int[] pose) {
        System.out.println("Pick a piece to promote that pawn into");
        System.out.println("(K)night, (B)ishop, (R)ook, or (Q)ueen");
        String s = sc.nextLine().trim().toLowerCase();
        while (!s.equals("k") && !s.equals("b") && !s.equals("r") && !s.equals("q")) {
            System.out.println("Please select either a (K)night, (B)ishop, (R)ook, or (Q)ueen");
            s = sc.nextLine().trim().toLowerCase();
            System.out.println();
        }
        setPiece(chessBoard[pose[0]][pose[1]],s);
    }
    public void setPiece(Piece p, String s) {
        int[] pose = p.getPose();
        String c = p.getColor();
        int i = 999999;
        int idx = p.getIndex();
        if(s.equals("k")) {
            i = promoteCounter[0];
            promoteCounter[0]++;
            System.out.println(i);
            chessBoard[pose[0]][pose[1]] = new Knight(c,pose[0],pose[1],i,idx);
        }
        if(s.equals("b")) {
            i = promoteCounter[1];
            promoteCounter[1]++;
            chessBoard[pose[0]][pose[1]] = new Bishop(c,pose[0],pose[1],i,idx);
        }
        if(s.equals("r")) {
            i = promoteCounter[2];
            promoteCounter[2]++;
            chessBoard[pose[0]][pose[1]] = new Rook(c,pose[0],pose[1],i,idx);
        }
        if(s.equals("q")) {
            i = promoteCounter[3];
            promoteCounter[3]++;
            chessBoard[pose[0]][pose[1]] = new Queen(c,pose[0],pose[1],i,idx);
        }
    }
    public String gameOver() {
        if (findPiece("wk") == null) {
            return "b";
        }
        else if (findPiece("bk") == null) {
            return "w";
        }
        else {
            return "continue";
        }
    }
}
