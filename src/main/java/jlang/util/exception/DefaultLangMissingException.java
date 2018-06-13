package jlang.util.exception;

public class DefaultLangMissingException extends RuntimeException {
    public DefaultLangMissingException(String lang_code) {
        super("In this application missing english language file (" + lang_code + ".xml), execution of JLang can't continue");
    }
}
