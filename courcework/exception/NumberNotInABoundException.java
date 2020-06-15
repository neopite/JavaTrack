package exception;

public class NumberNotInABoundException extends RuntimeException {
    public NumberNotInABoundException(String message){
        super(message);
    }
}
