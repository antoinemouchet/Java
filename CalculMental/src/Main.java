import Exceptions.UnknownOpException;
import java.io.BufferedReader;


/**
* @overview Main class
*/
public class Main {

    public static void main(String[] args) {
        // Values
        int firstNum, secondNum, result, resultIn, score = 0, totalNumber = 0;
        boolean playing = true;
        BufferedReader reader = Input.openInput();

        while (playing) {
            totalNumber ++;
            // Create new calcul
            String calcul = "%d %s %d = ?";
            // Random operation
            Operation randomOperation = Operation.randomOp();

            // Generate first randomNumber between 0 and max value of operation
            firstNum = MathOperations.getRandomNumber(randomOperation.getMax(), true);

            // Generate second number, has to be a divisor if operation is division
            switch (randomOperation) {
                case DIVISION:
                    secondNum = MathOperations.getRandomNumArray(firstNum);
                    break;

                case SUBTRACTION:
                    secondNum = MathOperations.getRandomNumber(firstNum, true);
                    break;

                default:
                    secondNum = MathOperations.getRandomNumber(randomOperation.getMax(), true);
            }

            calcul = String.format(calcul, firstNum, randomOperation.getSign(), secondNum);

            // Try to get the result of the operation
            try {
                result = Operation.getResult(randomOperation, firstNum, secondNum);
            } catch (UnknownOpException e) {
                System.out.println(e.getMessage());
                System.out.println("Calcul suivant.");
                continue;
            }

            System.out.println(String.format("Le calcul est: %s", calcul));
            resultIn = Game.getAnswer(reader);

            if(Game.checkResult(resultIn, result)){
                score++;
                System.out.println(String.format("Bien joué! Score: %d", score));
            }
            else{
                System.out.println(String.format("Bien essayé.\nLa réponse était: %d %s %d = %d", firstNum, randomOperation.getSign(),
                        secondNum, result));
            }

            // Every 10 computations, ask player if he wants to continue
            if(totalNumber % 10 == 0) {
                playing = Game.keepPlaying(reader);
            }
        }
        Game.goodbye(score, totalNumber);
        // Close input only if player is leaving
        Input.closeBuffer(reader);
    }
}
