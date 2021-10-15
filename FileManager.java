import java.io.IOException;

public class FileManager {

    public static void main(String[] args) throws IOException {

    File UserFile = new File();
    File TaskFile = new File();

    UserFile.newFile("UserFile.txt");
    TaskFile.newFile("TaskFile.txt");


    }

}
