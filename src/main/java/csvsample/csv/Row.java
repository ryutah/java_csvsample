package csvsample.csv;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Row {
    private Header       header;
    private List<String> columns;

    public Row(Header header, String... columns) {
        this.header = header;
        this.columns = Arrays.asList(columns);
    }

    public Row(Header header, List<String> columns) {
        this.header = header;
        this.columns = columns;
    }

    public List<String> columns() {
        return this.columns;
    }

    public Optional<String> column(String name) {
        Optional<Integer> index = this.header.index(name);
        return index.isPresent() ? this.column(index.get()) : Optional.empty();
    }

    public Optional<String> column(int index) {
        return index < this.columns.size() ? Optional.of(this.columns.get(index)) : Optional.empty();
    }
}
