package jlang.util.exception;

public class EnglishMissingException extends RuntimeException {
    public EnglishMissingException() {
        super("In this application missing english language file (en.xml), execution of JLang can't continue");
    }
}
