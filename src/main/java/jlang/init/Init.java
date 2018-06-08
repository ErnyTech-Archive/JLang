package jlang.init;

import jlang.Languages;
import jlang.parser.LangParserAll;
import jlang.util.exception.LanguageMissingException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class Init {
    public static void start(URI langsURI)  {
        var langParserAll = new LangParserAll(Paths.get(langsURI));
        langParserAll.parse();
        CheckEnglish.start();
        try {
            EnableDetectedLanguage.start();
        } catch (LanguageMissingException e) {
            Languages.set("en");
        }
    }

    public static void start(Path langsPath) {
        start(langsPath.toUri());
    }

    public static void start(Class jarClass, String jarPath) throws URISyntaxException, IOException {
        var uri = jarClass.getResource(jarPath).toURI();
        var filesystem = initFileSystem(uri);
        start(uri);
        filesystem.close();
    }

    private static FileSystem initFileSystem(URI uri) throws IOException {
        try {
            return FileSystems.getFileSystem(uri);
        } catch(FileSystemNotFoundException e) {
            Map<String, String> env = new HashMap<>();
            env.put("create", "true");
            return FileSystems.newFileSystem(uri, env);
        }
    }
}
