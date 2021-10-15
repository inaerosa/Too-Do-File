import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {

    private Path directory;

    public File() throws IOException{
        this.directory = Paths.get("src");
    }

    public void newFile(String name) throws IOException {
        Path newFile = this.directory.resolve(name);
        if (!Files.exists(newFile))
                Files.createFile(newFile);
    }

    public void deleteFile(String name) throws IOException{
        Path file = this.directory.resolve(name);
        Files.deleteIfExists(file);
    }

}
