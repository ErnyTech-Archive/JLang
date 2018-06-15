package jlang;

import jlang.detect.DetectLangCode;
import jlang.parser.GetFiles;
import jlang.parser.LangParserAll;
import jlang.util.AppendURI;
import jlang.util.exception.DefaultLangMissingException;
import jlang.util.exception.LanguageMissingException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class Init {
    public void start(URI langsURI, Languages languages, String lang_code)  {
        var langParserAll = new LangParserAll(Paths.get(langsURI), languages);
        langParserAll.parse();
        checkDefaultLang(languages, lang_code);
        try {
            enableDetectedLanguage(languages);
        } catch (LanguageMissingException e) {
            languages.set("en");
        }

    }

    public void start(Path langsPath, Languages languages, String lang_code) {
        start(langsPath.toUri(), languages, lang_code);
    }

    public void start(Class jarClass, String jarPath, Languages languages, String lang_code) throws URISyntaxException, IOException {
        var uri = jarClass.getResource(jarPath).toURI();
        var filesystem = initFileSystem(uri);
        var langPath = Paths.get(uri);
        var tempPath = Files.createTempDirectory(jarPath);
        copyDir(langPath, tempPath);
        filesystem.close();
        start(tempPath.toUri(), languages, lang_code);
        deleteDir(tempPath);
    }

    private FileSystem initFileSystem(URI uri) throws IOException {
        try {
            return FileSystems.getFileSystem(uri);
        } catch(FileSystemNotFoundException e) {
            Map<String, String> env = new HashMap<>();
            env.put("create", "true");
            return FileSystems.newFileSystem(uri, env);
        }
    }

    private void copyDir(Path srcDir, Path destDir) throws IOException {
        var srcPaths = new GetFiles(srcDir).getFiles();
        for (Path path : srcPaths) {
            var destPath = new AppendURI(destDir, path.getFileName().toString()).getPath();
            Files.copy(path, destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private void deleteDir(Path dirPath) throws IOException {
        var dirPaths = new GetFiles(dirPath).getFiles();
        for (Path path : dirPaths) {
            Files.delete(path);
        }
        Files.delete(dirPath);
    }

    private void checkDefaultLang(Languages languages, String lang_code)  {
        try {
            languages.set(lang_code);
        } catch (LanguageMissingException e) {
            throw new DefaultLangMissingException(lang_code);
        }
    }

    private void enableDetectedLanguage(Languages languages)  {
        var detectLangCode = new DetectLangCode();
        detectLangCode.detect();
        var detectedLang = detectLangCode.getDetectedLanguage();
        languages.set(detectedLang.getLangCode());
    }
}
