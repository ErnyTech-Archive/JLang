package jlang;

public class JLangString {
    private String stringName;
    private String stringValue;

    public JLangString(String stringName, String stringValue) {
        this.stringName = stringName;
        this.stringValue = stringValue;
    }

    String getStringName() {
        return this.stringName;
    }

    String getStringValue() {
        return this.stringValue;
    }
}
