import java.util.ArrayList;
import java.util.Random;

/**
* @overview Class implementing some operation on numbers
*/

public class MathOperations {
    private static Random random = new Random();

    /**
    * @requires number a positive integer
    * @return list of divisors of numbers
    */
    private static ArrayList<Integer> getDivisors(int number){
        ArrayList<Integer> divisors = new ArrayList<>();

        // Loop on all elements before number starting at 1
        for (int i = 1; i <= number; i++) {
            //  Result of division is an int
            if(number % i == 0){
                divisors.add(i);
            }
        }
        return divisors;
    }

    /**
    * @requires number, a positive integer
    * @return a random divisor of number
    */
    public static int getRandomNumArray(int number){
        ArrayList<Integer> list = getDivisors(number);
        return list.get(random.nextInt(list.size()));
    }

    /**
     * @requires max positive integer possible to generate
     * @requires included boolean (true if max is included)
     * @return a random number between 0 and max (included or not)
     */
    public static int getRandomNumber(int max, boolean included){
        Random randomGen = new Random();
        if(included) {
            return randomGen.nextInt(max) + 1;
        }
        else
        {
            return randomGen.nextInt(max);
        }
    }
}
