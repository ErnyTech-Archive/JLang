package jlang;

import jlang.init.Init;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class JLang {
    public static void start(URI langsURI) {
        Init.start(langsURI);
    }

    public static void start(Path langsPath) {
        Init.start(langsPath);
    }

    public static void start(Class jarClass, String jarPath) throws URISyntaxException, IOException {
        Init.start(jarClass, jarPath);
    }

    public static void setLang(String lang_code) {
        Languages.set(lang_code);
    }

    public static void setLang() {
        setLang("en");
    }

    public static String get(String jLangName) {
        var currentLanguage = Languages.getLanguage();
        for (JLangString jLangString : currentLanguage.getjLangStrings()) {
            if (jLangString.getStringName().equals(jLangName)) {
                return jLangString.getStringValue();
            }
        }
        return null;
    }
}
