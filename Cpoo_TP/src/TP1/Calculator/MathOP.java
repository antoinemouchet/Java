package TP1.Calculator;

/**
 * Class defining result of some operations
 */
public class MathOP {
    /**
     * Return addition of 2 numbers
     * @param value1 first operand
     * @param value2 second operand
     * @return result of the addition
     */
    public static int plus(int value1, int value2){
        return value1 + value2;
    }

    /**
     * Return substraction of 2 numbers
     * @param value1 first operand
     * @param value2 second operand
     * @return result of the substraction
     */
    public static int minus(int value1, int value2){
        return value1 - value2;
    }

    /**
     * Return divison of 2 numbers
     * @param value1 first operand
     * @param value2 second operand
     * @return result of the divison
     */
    public static float div(int value1, int value2){
        return (float) value1 / value2;
    }

    /**
     * Return multiplication of 2 numbers
     * @param value1 first operand
     * @param value2 second operand
     * @return result of the multiplication
     */
    public static int mul(int value1, int value2){
        return value1 * value2;
    }
}
