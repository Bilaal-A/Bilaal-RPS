import java.util.Objects;

/**
 * Each player or team will create their own Player, this is only an example....
 * 
 * Your code MUST INCLUDE a move method with the following signature. To ensure that, you must implement
 * the Player interface
 * 
 * You can create additional methods but must have the move method
 * 
 */
public class P5AshrafBilaal implements Player
{
    private static String name = "Bilaal";

    /**
     * An example of a method - replace this comment with your own
     * You must create some kind of logic of what to play against your opponent...start thinking!
     *
     * @return      the move you want to play against opponent
     *              "r" - rock
     *              "p" - paper
     *              "s" - scissors
     *              anything else - forfeit the turn
     */


    private int getCurrentMoveIndex(String[] moves) {
        int index = 0;
        while(moves[index] != null) {
            index++;
        }
        return index;
    }

    private int oneTwoThree(int x, int y) {
        x += y;
        if (x<1) {while (x < 1 || x > 3) {x+=3;}}
        if (x>3) {while (x < 1 || x > 3) {x-=3;}}
        return x;
    }

    private String threeCount(int currentTurn, String[] moves) {
        boolean check = false;
        for (int i=0; i<moves.length; i+=3) {
            if (currentTurn == i) {check = true;}
            if (check) {return "A";}
        }
        for (int i=1; i<moves.length; i+=3) {
            if (currentTurn == i) {check = true;}
            if (check) {return "B";}
        }
        for (int i=2; i<moves.length; i+=3) {
            if (currentTurn == i) {check = true;}
            if (check) {return "C";}
        }
        return "error";
    }

    private boolean reverser(boolean input) {
        if (input) {return false;}
        else {return true;}
    }

    private boolean allMovesSame(String [] opponentMoves) {
        return (opponentMoves[0].equals(opponentMoves[1]) && opponentMoves[0].equals(opponentMoves[2]) &&
                opponentMoves[0].equals(opponentMoves[3]) && opponentMoves[0].equals(opponentMoves[4]) &&
                opponentMoves[0].equals(opponentMoves[5]));
    }



    public String move(String [] myMoves, String [] opponentMoves, int myScore, int opponentScore)
    {
        int currentTurn = getCurrentMoveIndex(opponentMoves);

//      -----USE TURNS 0-5 TO TEST THEIR ALGORITHM-----
        if (currentTurn == 0 || currentTurn == 1) {
//            System.out.println("TOTAL TURNS: " + opponentMoves.length);
            return "r";
        }
        if (currentTurn == 2 || currentTurn == 3) {
            return "p";
        }
        if (currentTurn == 4 || currentTurn == 5) {
            return "s";
        }

        if (currentTurn == 6) {
//            System.out.println("FIRST 4 TURNS & RESPONSES");
            for (int i = 0; i < 6; i++) {
//                System.out.print("BILAAL: " + myMoves[i] + "     ");
//                System.out.println("OPPONENT: " + opponentMoves[i]);
            }

        }



//      -----CHECK FOR AND COUNTER PATTERNS------

        boolean allSame = allMovesSame(opponentMoves);

        boolean tripleRotate = (opponentMoves[0].equals(opponentMoves[3]) && opponentMoves[1].equals(opponentMoves[4])
                && opponentMoves[2].equals(opponentMoves[5]));
        boolean reverse = true;




//      All Rock
        if (allSame && opponentMoves[0].equals("r") && opponentMoves[currentTurn-1].equals("r")) {
            return "p";
        }
//      All Paper
        if (allSame && opponentMoves[0].equals("p") && opponentMoves[currentTurn-1].equals("p")) {
            return "s";
        }
//      All Scissors
        if (allSame && opponentMoves[0].equals("s") && opponentMoves[currentTurn-1].equals("s")) {
            return "r";
        }
//      Triple Rotate Start Rock
        if (tripleRotate && opponentMoves[0].equals("r") && opponentMoves[1].equals("p")) {
            if((threeCount(currentTurn, opponentMoves)).equals("A")) {return "p";}
            if((threeCount(currentTurn, opponentMoves)).equals("B")) {return "s";}
            if((threeCount(currentTurn, opponentMoves)).equals("C")) {return "r";}
        }
//      Triple Rotate Start Paper
        if (tripleRotate && opponentMoves[0].equals("p") && opponentMoves[1].equals("s")) {
            if((threeCount(currentTurn, opponentMoves)).equals("A")) {return "s";}
            if((threeCount(currentTurn, opponentMoves)).equals("B")) {return "r";}
            if((threeCount(currentTurn, opponentMoves)).equals("C")) {return "p";}
        }
//      Triple Rotate Start Scissors
        if (tripleRotate && opponentMoves[0].equals("s") && opponentMoves[1].equals("r")) {
            if((threeCount(currentTurn, opponentMoves)).equals("A")) {return "r";}
            if((threeCount(currentTurn, opponentMoves)).equals("B")) {return "p";}
            if((threeCount(currentTurn, opponentMoves)).equals("C")) {return "s";}
        }
        //Triple Rotate REVERSE Start Rock
        if (tripleRotate && opponentMoves[0].equals("r") && opponentMoves[1].equals("s")) {
            if((threeCount(currentTurn, opponentMoves)).equals("A")) {return "p";}
            if((threeCount(currentTurn, opponentMoves)).equals("B")) {return "r";}
            if((threeCount(currentTurn, opponentMoves)).equals("C")) {return "s";}
        }
//      Triple Rotate REVERSE Start Paper
        if (tripleRotate && opponentMoves[0].equals("p") && opponentMoves[1].equals("r")) {
            if((threeCount(currentTurn, opponentMoves)).equals("A")) {return "s";}
            if((threeCount(currentTurn, opponentMoves)).equals("B")) {return "p";}
            if((threeCount(currentTurn, opponentMoves)).equals("C")) {return "r";}
        }
//      Triple Rotate REVERSE Start Scissors
        if (tripleRotate && opponentMoves[0].equals("s") && opponentMoves[1].equals("p")) {
            if((threeCount(currentTurn, opponentMoves)).equals("A")) {return "r";}
            if((threeCount(currentTurn, opponentMoves)).equals("B")) {return "s";}
            if((threeCount(currentTurn, opponentMoves)).equals("C")) {return "p";}
        }
//      Prokopiy WL+1/T-1 Start Paper RPS
        if (opponentMoves[0].equals("p") &&
                opponentMoves[1].equals("s") &&
                opponentMoves[2].equals("r") &&
                opponentMoves[3].equals("p") &&
                opponentMoves[4].equals("r") &&
                opponentMoves[5].equals("p")) {
            if((threeCount(currentTurn, opponentMoves)).equals("A")) {return "r";}
            if((threeCount(currentTurn, opponentMoves)).equals("B")) {return "p";}
            if((threeCount(currentTurn, opponentMoves)).equals("C")) {return "s";}
        }
//      -----NO PATTERN DETECTED-----

        else {
            int x = oneTwoThree(1, 0);
            boolean won = ((Objects.equals(myMoves[currentTurn - 1], "r")) && (Objects.equals(opponentMoves[currentTurn - 1], "s")) ) ||
                    ((Objects.equals(myMoves[currentTurn - 1], "p")) && (Objects.equals(opponentMoves[currentTurn - 1], "r")) ) ||
                    ((Objects.equals(myMoves[currentTurn - 1], "s")) && (Objects.equals(opponentMoves[currentTurn - 1], "p")) );

            boolean lost = ((Objects.equals(myMoves[currentTurn - 1], "r")) && (Objects.equals(opponentMoves[currentTurn - 1], "p")) ) ||
                    ((Objects.equals(myMoves[currentTurn - 1], "p")) && (Objects.equals(opponentMoves[currentTurn - 1], "s")) ) ||
                    ((Objects.equals(myMoves[currentTurn - 1], "s")) && (Objects.equals(opponentMoves[currentTurn - 1], "r")) );

            boolean tie = ((Objects.equals(myMoves[currentTurn - 1], "r")) && (Objects.equals(opponentMoves[currentTurn - 1], "r")) ) ||
                    ((Objects.equals(myMoves[currentTurn - 1], "p")) && (Objects.equals(opponentMoves[currentTurn - 1], "p")) ) ||
                    ((Objects.equals(myMoves[currentTurn - 1], "s")) && (Objects.equals(opponentMoves[currentTurn - 1], "s")) );

            if (won && Objects.equals(myMoves[currentTurn - 1], "r")) {return "r";}
            if (won && Objects.equals(myMoves[currentTurn - 1], "p")) {return "p";}
            if (won && Objects.equals(myMoves[currentTurn - 1], "s")) {return "s";}
            if (tie && Objects.equals(myMoves[currentTurn - 1], "r")) {return "p";}
            if (tie && Objects.equals(myMoves[currentTurn - 1], "p")) {return "r";}
            if (tie && Objects.equals(myMoves[currentTurn - 1], "s")) {return "s";}
            if (lost && Objects.equals(myMoves[currentTurn - 1], "r")) {return "s";}
            if (lost && Objects.equals(myMoves[currentTurn - 1], "p")) {return "p";}
            if (lost && Objects.equals(myMoves[currentTurn - 1], "s")) {return "r";}

//            if (myScore<opponentScore) {reverser(reverse);}
//            if (opponentMoves[currentTurn-1].equals("r")) {
//                if (reverse) {return "s";}
//                else {return "p";}
//            }
//            if (opponentMoves[currentTurn-1].equals("p")) {
//                if (reverse) {return "r";}
//                else {return "s";}
//            }
//            else {
//                if (reverse) {return "p";}
//                else {return "r";}
//            }
        }



        return "s";

    }


    /**
     * Returns the name of the player
     *
     * @return      the name of the player
     */
    public String getName()
    {
        return name;
    }
}

