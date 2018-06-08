package jlang.init;

import jlang.Languages;
import jlang.detect.DetectLangCode;
import jlang.util.exception.LanguageMissingException;

class EnableDetectedLanguage {
    static void start() throws LanguageMissingException {
        var detectLangCode = new DetectLangCode();
        detectLangCode.detect();
        var detectedLang = detectLangCode.getDetectedLanguage();
        Languages.set(detectedLang.getLangCode());
    }
}
