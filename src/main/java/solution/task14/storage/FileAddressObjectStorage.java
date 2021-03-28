package solution.task14.storage;

import solution.task14.abook.model.AddressItem;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Klasa implementuje interfejs Storage zapisując dane kolekcji elementów AddressItem serializowane do pliku
 * Można zaimplementować inną klasę np. FileAddresTextStorage, która zapisze dane kolekcji do pliku tekstowego
 */
public class FileAddressObjectStorage implements Storage<AddressItem>{
    private final String pathToFile;
    private final Logger logger = Logger.getLogger(FileAddressObjectStorage.class.getName());


    public FileAddressObjectStorage(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public void save(List<AddressItem> items) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(pathToFile));
        stream.writeObject(items);
        logger.info("Data saved to file: " + pathToFile + ". Collection size: " + items.size());
        stream.close();
    }

    @Override
    public List<AddressItem> load() throws IOException, ClassNotFoundException {
        if (!Files.exists(Path.of(pathToFile))) {
            logger.info("File not exists. Staring with empty collection.");
            return new ArrayList<>();
        }
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(pathToFile));
        List<AddressItem> loaded = (List<AddressItem>) stream.readObject();
        logger.info("Data loaded. Collection size: " + loaded.size());
        return loaded;

    }
}
