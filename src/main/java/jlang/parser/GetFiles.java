package jlang.parser;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class GetFiles {
    private Path langsPath;

    GetFiles(Path langsPath) {
        this.langsPath = langsPath;
    }

    List<Path> getFiles() {
        var files = new ArrayList<Path>();

        DirectoryStream<Path> directoryStream;
        try {
            directoryStream = Files.newDirectoryStream(this.langsPath);
        } catch (IOException e) {
            return files;
        }

        for (Path path : directoryStream) {
            if (!path.getFileName().toString().contains(".xml")) {
                continue;
            }

            files.add(path);
        }
        return files;
    }
}
