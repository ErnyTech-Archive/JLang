package jlang;

import jlang.util.exception.LanguageMissingException;

import java.util.ArrayList;
import java.util.List;

public class Languages {
    private static Language language;
    private static List<Language> languages = new ArrayList<>();

    public static void set(String lang_code) throws LanguageMissingException {
        for (Language language : Languages.languages) {
            if (language.getLangCode().equals(lang_code)) {
                Languages.language = language;
                return;
            }
        }
        throw new LanguageMissingException("Language: " + lang_code + " is missing");
    }

    static Language getLanguage() {
        return Languages.language;
    }

    public static void addLanguage(Language language) {
        Languages.languages.add(language);
    }

    public static List<Language> getLanguages() {
        return Languages.languages;
    }
}
