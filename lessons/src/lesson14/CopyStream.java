package lesson14;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

public class CopyStream {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java CopyStream <URL> <file>");
            System.err.println("CopyStream copies a web page to a file.");
            System.exit(-1);
        }

        // Open the file to write to
        Path path = Paths.get("C:\\Users\\user1\\Documents\\CodeCollegeZA\\BootCamp_2023\\javaAdvanced\\coursework\\lessons\\src\\lesson14\\a.txt");
        URI u = URI.create("file:///C:/Users/user1/Documents/CodeCollegeZA/BootCamp_2023/javaAdvanced/coursework/lessons/src/lesson14/a.txt");
        try (InputStream in = u.toURL().openStream()) {
            Files.copy(in, path, REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Exception: " + e);
        }
    }
}