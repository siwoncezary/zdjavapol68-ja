package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NIODemo {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("c:\\data\\data.txt");
        List<String> names = Files.readAllLines(file);
        System.out.println(names);
    }
}
