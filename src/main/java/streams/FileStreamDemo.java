package streams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class User{
    String name;
    String email;
    int pin;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pin=" + pin +
                '}';
    }
}
public class FileStreamDemo {

    public static final String DATA_TEST_TXT = "c:\\data\\test.txt";

    public static void main(String[] args) throws IOException {
        List<User> users = Collections.emptyList();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_TEST_TXT))) {
             users = reader.lines()
                    .map(line -> {
                        String[] tokens = line.split("\\t");
                        User user = new User();
                        user.name = tokens[0];
                        user.email = tokens[1];
                        user.pin = Integer.parseInt(tokens[2]);
                        return user;
                    })
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.err.println("Brak takiego pliku");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(users);
        User tomek = new User();
        tomek.pin = 8883;
        tomek.email = "tom@tom.ru";
        tomek.name ="Tomasz";
        users.add(tomek);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_TEST_TXT))) {
            users.stream()
                    .forEach(user -> {
                        try {
                            writer.write(user.name+"\t"+user.email+"\t"+user.pin+System.lineSeparator());
                        } catch (IOException e) {
                            System.err.println("Zapis nie powiódł się!!!");
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path file = Paths.get(DATA_TEST_TXT);
        Files.copy(file, new FileOutputStream("c:\\data\\test_copy.txt"));
    }
}
