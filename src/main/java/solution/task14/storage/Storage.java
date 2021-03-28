package solution.task14.storage;

import java.io.IOException;
import java.util.List;

/**
 * Prosty interfejs generyczny do utrwalania danych w naszej aplikacji
 * @param <T> typ elementu utrwalanej  lub odczytywanej kolekcji
 */
public interface Storage<T> {
    void save(List<T> items) throws IOException;
    List<T> load() throws IOException, ClassNotFoundException;
}
