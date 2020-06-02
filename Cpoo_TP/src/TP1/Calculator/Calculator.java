package TP1.Calculator;

/**
 * Class defining a calculator method which acts like a computing machine with a set of supported operations.
 */
public class Calculator {
    /**
     * Function acting like a calculator.
     */
    public static void calculator(){
        String reading = "";
        float result = 0;
        boolean success = true;

        // Store value used for computations (Operand1, operand2, operation)
        String[] computation = new String[3];

        System.out.println("~~ Welcome to this calculator ~~ ");

        // Loop until user leaves
        while (!reading.equalsIgnoreCase("quit")){

            System.out.println("Insert first value");
            computation[0] = getInput.get_input();

            System.out.println("Insert second value");
            computation[1] = getInput.get_input();

            System.out.println("Insert operand (+,-,/,*)");
            computation[2] = getInput.get_input();

            // Actual computation
            // Only operations supported by TP1.Calculator.MathOP
            // Add operations there then here for more.
            switch (computation[2]){
                case "+":
                    result = MathOP.plus(Integer.parseInt(computation[0]), Integer.parseInt(computation[1]));
                    break;
                case "-":
                    result = MathOP.minus(Integer.parseInt(computation[0]), Integer.parseInt(computation[1]));
                    break;
                case "*":
                    result = MathOP.mul(Integer.parseInt(computation[0]), Integer.parseInt(computation[1]));
                    break;
                case "/":
                    if(Integer.parseInt(computation[1]) != 0) {
                        result = MathOP.div(Integer.parseInt(computation[0]), Integer.parseInt(computation[1]));
                    }
                    else{
                        success = false;
                        System.out.println("Division by 0 not allowed");
                    }
                    break;
                default:
                    System.out.println("Operand unknown.");
                    success = false;
                    break;
            }

            // Display result if operation was successful
            if(success){
                System.out.println(String.format("%d %s %d = %.2f", Integer.parseInt(computation[0]),
                        computation[2], Integer.parseInt(computation[1]), result));
            }

            // Reset success value
            success = true;

            // Ask user if he wants to keep going
            System.out.println("Insert 'quit' to exit calculator, press any key to keep going.");
            reading = getInput.get_input();
        }
        System.out.println("Thanks for using this calculator.\n\n~~ Goodbye ~~");

        // Close streams
        getInput.closeStreams();
    }
}
