package jlang.init;

import jlang.Languages;
import jlang.util.exception.EnglishMissingException;
import jlang.util.exception.LanguageMissingException;

class CheckEnglish {
    static void start() {
        try {
            Languages.set("en");
        } catch (LanguageMissingException e) {
            throw new EnglishMissingException();
        }
    }
}
