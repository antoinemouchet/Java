import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
* @overview class dedicated to functions for the game
*/
public class Game {

    /**
     * @requires firstNum positive integer
     * @requires secondNum positive integer
     * @return a boolean if first and second numbers are the same
     */
    public static boolean checkResult(int firstNum, int secondNum){
        if(firstNum == secondNum){
            return  true;
        }
        return false;
    }


    /**
     * @requires  initialized reader
     * @return a boolean based on input
     */
    public static boolean keepPlaying(BufferedReader reader){
        String input = Input.getInput(reader, "Continuez à jouer? (o/n)");
        if(input.equals("n")){
            System.out.println("Au revoir.");
            return false;
        }
        return true;
    }

    /**
     * @requires  initialized reader
     * @return answer inserted by user as an int
     */
    public static int getAnswer(BufferedReader reader){
        String input = Input.getInput(reader, "Entrez votre réponse: ");
        return Integer.parseInt(input);
    }

    /**
    * @modifies output stream
    * @effects display text on the output stream (screen here)
    */
    public static void goodbye(int finalScore, int total){
        System.out.println(String.format("Merci d'avoir joué.\nTon score final est de: %d/%d", finalScore, total));
    }

}
