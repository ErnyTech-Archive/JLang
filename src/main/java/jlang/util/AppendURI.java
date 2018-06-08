package jlang.util;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppendURI {
    private URI uri;
    private String pathToAppend;

    public AppendURI(URI uri, String pathToAppend) {
        this.uri = uri;
        this.pathToAppend = pathToAppend;
    }

    public AppendURI(Path path, String pathToAppend) {
        this.uri = path.toUri();
        this.pathToAppend = pathToAppend;
    }

    public AppendURI(File file, String pathToAppend) {
        this.uri = file.toURI();
        this.pathToAppend = pathToAppend;
    }

    public URI getAppendURI() {
        try {
            return new URI(this.uri.toString() + File.separator + this.pathToAppend);
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public Path getPath() {
        return Paths.get(getAppendURI());
    }

    public File getFile() {
        return new File(getAppendURI());
    }
}
