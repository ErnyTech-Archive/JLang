package jlang.parser;

import jlang.JLangString;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class LangParser {
    private Path langFile;

    LangParser(Path langFile) {
        this.langFile = langFile;
    }

    List<JLangString> getJLangStrings() throws ParserConfigurationException, IOException, SAXException {
        var jLangStrings = new ArrayList<JLangString>();
        var dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        var doc = dBuilder.parse(this.langFile.toFile());
        doc.normalizeDocument();
        var stringNode = doc.getElementsByTagName("string");

        for (int i = 0; i < stringNode.getLength(); i++) {
            if (stringNode.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            var element = (Element) stringNode.item(i);

            var stringName = element.getAttribute("name");
            var stringValue = element.getTextContent();

            var jLangString = new JLangString(stringName, stringValue);
            jLangStrings.add(jLangString);
        }
        return jLangStrings;
    }
}
