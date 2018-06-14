package jlang;

import jlang.util.exception.InitException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class JLang {
    private static Init init = new Init();
    private static Languages languages = new Languages();
    private static String defaultLang_code;

    public static void start(URI langsURI, String defaultLang_code) {
        JLang.defaultLang_code = defaultLang_code;
        JLang.init.start(langsURI, JLang.languages, defaultLang_code);

    }

    public static void start(URI langsURI) {
        start(langsURI, "en");
    }

    public static void start(Path langsPath, String defaultLang_code) {
        JLang.defaultLang_code = defaultLang_code;
        JLang.init.start(langsPath, JLang.languages, defaultLang_code);
    }

    public static void start(Path langsPath) {
        start(langsPath, "en");
    }

    public static void start(String jarPath, String defaultLang_code, Class callerClass) {
        try {
            JLang.defaultLang_code = defaultLang_code;
            JLang.init.start(callerClass, jarPath, JLang.languages, defaultLang_code);
        } catch (Exception e) {
            throw new InitException(e);
        }
    }
    
    public static void start(String jarPath, String defaultLang_code) {
        try {
            var callerClass = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
            start(jarPath, defaultLang_code, callerClass);
        } catch (Exception e) {
            throw new InitException(e);
        }
    }

    public static void start(String jarPath) {
        try {
            var callerClass = Class.forName(Thread.currentThread().getStackTrace()[2].getClassName());
            start(jarPath, "en", callerClass);
        } catch (Exception e) {
            throw new InitException(e);
        }
    }

    public static void setLang(String lang_code) {
        JLang.languages.set(lang_code);
    }

    public static void setLang() {
        setLang(JLang.defaultLang_code);
    }

    public static String get(String jLangName) {
        var currentLanguage = JLang.languages.getLanguage();
        for (JLangString jLangString : currentLanguage.getjLangStrings()) {
            if (jLangString.getStringName().equals(jLangName)) {
                return jLangString.getStringValue();
            }
        }
        return getDefault(jLangName);
    }

    public static String getLang() {
        return JLang.languages.getLanguage().getLangCode();
    }

    private static String getDefault(String jLangName) {
        var currentLanguage = JLang.languages.getLanguage(JLang.defaultLang_code);
        for (JLangString jLangString : currentLanguage.getjLangStrings()) {
            if (jLangString.getStringName().equals(jLangName)) {
                return jLangString.getStringValue();
            }
        }
        return null;
    }
}
