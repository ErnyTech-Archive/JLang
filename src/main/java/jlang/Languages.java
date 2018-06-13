package jlang;

import jlang.util.exception.LanguageMissingException;

import java.util.ArrayList;
import java.util.List;

public class Languages {
    private Language defaultLanguage;
    private List<Language> languages = new ArrayList<>();

    public void set(String lang_code) throws LanguageMissingException {
        for (Language language : this.languages) {
            if (language.getLangCode().equals(lang_code)) {
                this.defaultLanguage = language;
                return;
            }
        }
        throw new LanguageMissingException(lang_code);
    }

    Language getLanguage() {
        return this.defaultLanguage;
    }

    Language getLanguage(String lang_code) throws LanguageMissingException {
        for (Language language : this.languages) {
            if (language.getLangCode().equals(lang_code)) {
                return language;
            }
        }
        throw new LanguageMissingException(lang_code);
    }

    public void addLanguage(Language language) {
        this.languages.add(language);
    }

    public List<Language> getLanguages() {
        return this.languages;
    }
}
