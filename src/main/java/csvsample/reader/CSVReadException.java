package csvsample.reader;

public class CSVReadException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CSVReadException(String msg) {
        super(msg);
    }

    public CSVReadException(Exception e) {
        super(e);
    }
}
