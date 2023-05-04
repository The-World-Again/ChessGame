import java.util.Arrays;

/**
 * Program that runs the game
 * @Ori
 */
public class GameRunner
{
    /**
     * Starts the game
     */
    public static void main(String[] args)
    {
        Board gameBoard = new Board();
        gameBoard.newGame();
        gameBoard.movePiece("E5","E6");
        for (Piece[] pieces : Board.getBoard()) {
            System.out.println(Arrays.toString(pieces));
        }
    }
}
