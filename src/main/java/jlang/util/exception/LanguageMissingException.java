package jlang.util.exception;

public class LanguageMissingException extends RuntimeException {
    public LanguageMissingException(String lang_code) {
        super("Language: " + lang_code + " is missing");
    }
}
