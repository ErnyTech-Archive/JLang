package jlang.javafx;

import javafx.beans.NamedArg;
import jlang.JLang;

public class Text extends javafx.scene.text.Text {
    private String jLangName;

    public Text(@NamedArg("jLangName") String jLangName) {
        super(getString(jLangName));
        this.jLangName = jLangName;
    }

    public Text(@NamedArg("x") double x, @NamedArg("y") double y, @NamedArg("jLangName") String jLangName) {
        super(x, y, getString(jLangName));
        this.jLangName = jLangName;
    }

    public void refresh() {
        setText(getString(this.jLangName));
    }

    private static String getString(String jLangName) {
        return JLang.get(jLangName);
    }
}
