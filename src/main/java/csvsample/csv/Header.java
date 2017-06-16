package csvsample.csv;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Header {
    private List<String> headers;

    public Header(String... headers) {
        this.headers = Arrays.asList(headers);
    }

    public Header(List<String> headers) {
        this.headers = headers;
    }

    public List<String> headers() {
        return this.headers;
    }

    public Optional<String> header(int index) {
        return null;
    }

    public Optional<Integer> index(String name) {
        Optional<String> header = this.headers.stream().filter(h -> h.equals(name)).findFirst();
        if (!header.isPresent())
            return Optional.empty();
        return Optional.of(this.headers.indexOf(header.get()));
    }
}
