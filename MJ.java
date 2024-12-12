import java.util.*;

public class MJ implements Player
{
    private static String name = "Mengjiao";

    public String move(String [] myMoves, String [] opponentMoves, int myScore, int opponentScore)
    {
        // Find the current move index
        int moveIndex = getMostRecentMoveIndex(opponentMoves);
        // Check that the index is greater than zero to avoid out of bounds error.
        if (moveIndex > 0)
        {
            String previousMove = opponentMoves[moveIndex-1];
            return moveToLose(previousMove);
        }
        // Return a fixed move at the start of the game.
        return "p";
    }

    // Find out which move the game is on.
    private int getMostRecentMoveIndex(String[] moves)
    {
        // The array will have data for each move, the rest of the array is "null"
        // Count how many elements in the array have data and stop counting when we get a null.

        // Example: ["p", "p", null, null, ...]
        // In this example, there were two moves so far.
        // The index will get incremented twice, once for each "p" in the array.

        int index = 0;
        while (moves[index] != null)
        {
            index++;
        }
        return index;
    }

    // Given a move, return the move that would lose.
    private String moveToLose(String move)
    {
        // String with input-output moves
        // r->s s->p p->r
        String moves = "rspr";
        // Find the input move index
        int index = moves.indexOf(move);
        // Return the next character in the string - the output move.
        return moves.substring(index+1, index+2);
    }

    public String getName()
    {
        return name;
    }
}

