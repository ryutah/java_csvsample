package csvsample.csv;

public class CSVParseException extends RuntimeException {
    static final long serialVersionUID = 1L;

    public CSVParseException(Exception e) {
        super(e);
    }
}
