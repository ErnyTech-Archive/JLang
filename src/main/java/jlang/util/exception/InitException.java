package jlang.util.exception;

public class InitException extends RuntimeException {
    public InitException() {
        super("Something wrong in init start!");
    }
}
