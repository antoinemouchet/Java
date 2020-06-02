import Exceptions.UnknownOpException;
import java.util.Random;

/**
* @overview Enum for the supported operations
*/

public enum Operation {
    ADDITION("Addition", "+", 50),
    SUBTRACTION("Soustraction", "-",50),
    MULTIPLICATION("Multiplication", "x",10),
    DIVISION("Division", "/",100);

    private static final Operation[] VALUES = Operation.values();
    private static final Random random = new Random();

    private final String name;
    private final String sign;
    private final int max;

    /**
    * Constructor of the operation enum
    */
    private Operation(String name, String sign, int max){
        this.name = name;
        this.sign = sign;

        this.max = max;
    }

    /**
    * @return name of the operation as a String
    */
    public String getName() {
        return name;
    }

    /**
    * @return sign of the operation as a String
    */
    public String getSign() {
        return sign;
    }

    /**
     * @return max number of the operation
     */
    public int getMax() {
        return max;
    }

    /**
    * @requires firstOperand & secondOperand positive integers
    * @throws UnknownOpException if operation is not supported
    * @return result of the operation between first and second
    */
    public static int getResult(Operation operation, int firstOperand, int secondOperand) throws UnknownOpException {
        switch (operation){
            case ADDITION:
                return firstOperand + secondOperand;

            case SUBTRACTION:
                return firstOperand - secondOperand;

            case DIVISION:
                return  firstOperand / secondOperand;

            case MULTIPLICATION:
                return firstOperand * secondOperand;

            // Unsupported operation
            default:
                throw new UnknownOpException("L'opération demandée n'est pas disponible.");
        }

    }

    /**
    * @return a random operation
    */
    public final static Operation randomOp(){
        return VALUES[random.nextInt(VALUES.length)];
    }



}
