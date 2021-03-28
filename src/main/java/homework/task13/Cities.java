package homework.task13;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

public class Cities {
    public static List<City> loadCities(InputStream input) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, Charset.forName("UTF-8")));
        return reader.lines().map(line -> {
            String[] current = line.split("\\t");
            City city = new City(
                    Long.parseLong(current[0]),
                    current[1],
                    Float.parseFloat(current[4]),
                    Float.parseFloat(current[5]),
                    current[8],
                    Integer.parseInt(current[14])
            );
            return city;
        }).collect(Collectors.toList());
    }
}