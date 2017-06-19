package csvsample.csv;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import csvsample.reader.CSVReader;

public class CSV implements Collection<Row> {
    private Header    header;
    private List<Row> rows;

    public CSV(CSVReader reader) {
        Queue<String[]> csv = new ArrayDeque<>(reader.read());
        this.header = new Header(csv.poll());
        this.rows = csv.stream().map(r -> new Row(this.header, r)).collect(Collectors.toList());
    }

    public Header header() {
        return this.header;
    }

    public List<Row> rows() {
        return this.rows();
    }

    public Optional<Row> row(int index) {
        return this.rows.size() > index ? Optional.of(this.rows.get(index)) : Optional.empty();
    }

    @Override
    public int size() {
        return this.rows.size();
    }

    @Override
    public boolean isEmpty() {
        return this.rows.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.rows.contains(o);
    }

    @Override
    public Iterator<Row> iterator() {
        return this.rows.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.rows.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return this.rows.toArray(a);
    }

    @Override
    public boolean add(Row e) {
        return this.rows.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return this.rows.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.rows.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Row> c) {
        return this.rows.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.rows.removeAll(c);
    }

    @Override
    public boolean removeIf(Predicate<? super Row> filter) {
        return this.rows.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.rows.retainAll(c);
    }

    @Override
    public void clear() {
        this.rows.clear();
    }

    @Override
    public Spliterator<Row> spliterator() {
        return this.rows.spliterator();
    }

    @Override
    public Stream<Row> stream() {
        return this.rows.stream();
    }

    @Override
    public Stream<Row> parallelStream() {
        return this.rows.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super Row> action) {
        this.rows.forEach(action);
    }
}
