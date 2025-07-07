package level01.exercise01.exeptions;

/**
 * PROGRAM: Hal9000Exception
 * AUTHOR: Diego Balaguer
 * DATE: 27/05/2025
 */

public class Hal9000Exception extends Exception {
    public Hal9000Exception(String message) {
        super("I'm sorry, Dave. I'm afraid I can't do that... " + message);
    }
}
