package jlang.detect;

import jlang.Language;

import java.util.Objects;

public class DetectLangCode {
    private String lang_code;

    public void detect() {
        var lang_code = System.getProperty("user.language");
        if (new CheckLangCode(lang_code).isOk()) {
            this.lang_code = lang_code;
        }
    }

    public Language getDetectedLanguage() {
        return new Language(Objects.requireNonNullElse(this.lang_code, "en"));
    }
}
