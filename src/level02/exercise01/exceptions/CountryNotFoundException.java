package level02.exercise01.exceptions;

public class CountryNotFoundException extends Exception {
    public CountryNotFoundException() {
        super("Country not found in the system.");
    }
}
