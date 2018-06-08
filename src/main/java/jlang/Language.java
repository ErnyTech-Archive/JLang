package jlang;

import java.nio.file.Path;
import java.util.List;

public class Language {
    private String lang_code;
    private Path lang_path;
    private List<JLangString> jLangStrings;

    public Language(String lang_code) {
        this.lang_code = lang_code;
    }

    public Language(String lang_code, Path lang_path, List<JLangString> jLangStrings) {
        this.lang_code = lang_code;
        this.lang_path = lang_path;
        this.jLangStrings = jLangStrings;
    }

    public void setLangPath(Path lang_path) {
        this.lang_path = lang_path;
    }

    public void setJLangStrings(List<JLangString> jLangStrings) {
        this.jLangStrings = jLangStrings;
    }

    public String getLangCode() {
        return this.lang_code;
    }

    public Path getLangPath() {
        return this.lang_path;
    }

    List<JLangString> getjLangStrings() {
        return this.jLangStrings;
    }

    public boolean equals(Language lang) {
        return this.lang_code.equals(lang.getLangCode());
    }
}
