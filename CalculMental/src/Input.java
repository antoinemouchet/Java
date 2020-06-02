import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @overview class for input management
*/
public class Input {

    /**
    * @return a new bufferedReader to read input Stream from SystemIn
    */
    public static BufferedReader openInput(){
        return new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * @requires initialized reader
     * @requires a message to display
     * @return input inserted by user as a String
     */
    public static String getInput(BufferedReader reader, String message){
        String input;
        try {
            System.out.println(message);
            input = reader.readLine();
        } catch (IOException e){
            System.out.println("Problem with input");
            return "";
        }

        return input;
    }

    /**
    * @requires initialized and open input stream
    * @modifies reader
    * @effects close reader
    */
    public static void closeBuffer(BufferedReader reader){
        try{
            reader.close();
        }catch (IOException e) {
            System.out.println("Problem when closing stream");
        }
    }
}
