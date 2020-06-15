package exception;

public class InvalidFormatDepartmentException extends RuntimeException {
    public InvalidFormatDepartmentException() {
        super("Department " + " contains invalid symbols,try again . Type of exception : "+ InvalidFormatDepartmentException.class);
    }
    public InvalidFormatDepartmentException(String message){
        super(message);
    }
}
