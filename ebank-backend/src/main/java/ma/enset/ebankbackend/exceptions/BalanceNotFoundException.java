package ma.enset.ebankbackend.exceptions;

public class BalanceNotFoundException extends Exception {
    public BalanceNotFoundException(String message) {
        super(message);
    }
}
