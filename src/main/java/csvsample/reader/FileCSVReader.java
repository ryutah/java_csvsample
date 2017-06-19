package csvsample.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileCSVReader implements CSVReader {

    private Path path;

    public FileCSVReader(String filepath) {
        this.path = Paths.get(filepath);
    }

    @Override
    public List<String[]> read() {
        try {
            List<String> lines = Files.readAllLines(this.path);
            List<String[]> csv = lines.stream()
                                      .map(r -> r.split(","))
                                      .collect(Collectors.toList());

            if (!this.isValid(csv))
                throw new CSVReadException("Invalid csv");

            return csv;
        } catch (IOException e) {
            throw new CSVReadException(e);
        }
    }
}
