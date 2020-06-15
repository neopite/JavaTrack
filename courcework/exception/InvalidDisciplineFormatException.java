package exception;

public class InvalidDisciplineFormatException extends RuntimeException{
    public InvalidDisciplineFormatException(){
        super("Dicipline"+ " contains invalid sybmols . Type of exception : "+ InvalidDisciplineFormatException.class);
    }
    public InvalidDisciplineFormatException(String message){
        super(message);
    }
}
