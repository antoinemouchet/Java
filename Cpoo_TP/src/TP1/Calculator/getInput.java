package TP1.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class to manage input from users.
 */
public class getInput {

    // Set up reader flux and buffer
    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);

    /**
     * @return string inserted by the user.
     */
    public static String get_input() {

        String input = "";

        try {
            // Get actual input
            input = br.readLine();
        }
        catch(IOException err) {
            System.out.println("I/O error: "+ err);
        }

        return input;
    }

    /**
     * Function to close all streams opened when using this class.
     * Call it at the end of the program.
     */
    public static void closeStreams() {
        try {
            br.close();
            isr.close();
        }
        catch(IOException err) {
            System.out.println("I/O error: "+ err);
        }
    }
}