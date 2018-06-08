package jlang.parser;

import jlang.Language;
import jlang.Languages;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;

public class LangParserAll {
    private Path langsPath;

    public LangParserAll(Path langsPath) {
        this.langsPath = langsPath;
    }

    public void parse() {
        var paths = new GetFiles(this.langsPath).getFiles();

        for (Path path : paths) {
            var langParser = new LangParser(path);
            var langCode = path.getFileName().toString().replace(".xml", "");
            try {
                Languages.addLanguage(new Language(langCode, path, langParser.getJLangStrings()));
            } catch (ParserConfigurationException | IOException | SAXException ignored) {
            }
        }
    }
}
