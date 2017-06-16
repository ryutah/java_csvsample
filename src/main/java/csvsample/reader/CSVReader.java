package csvsample.reader;

import java.util.List;

public interface CSVReader {
    List<String[]> read();

    default boolean isValid(List<String[]> csv) {
        int headerSize = csv.get(0).length;
        return csv.stream().allMatch(c -> c.length == headerSize);
    }
}
