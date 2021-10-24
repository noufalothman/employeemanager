package tech.getarrays.employeemanager.exception;

public class UsernotFoundException extends RuntimeException{
    public UsernotFoundException(String message) {
        super(message);
    }
}
