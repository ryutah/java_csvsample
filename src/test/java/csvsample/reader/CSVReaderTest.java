package csvsample.reader;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CSVReaderTest {
    private CSVReader reader;

    @Before
    public void createInstance() {
        this.reader = () -> new ArrayList<>();
    }

    @Test
    public void testIsValidForValidCSV() {
        String[] header = { "foo", "bar", "foobar" };
        String[] row1 = { "FOO1", "BAR1", "FOOBAR1" };
        String[] row2 = { "FOO2", "BAR2", "" };
        String[] row3 = { "", "", "" };
        List<String[]> csv = new ArrayList<>();
        csv.add(header);
        csv.add(row1);
        csv.add(row2);
        csv.add(row3);

        assertTrue(reader.isValid(csv));
    }

    @Test
    public void testIsValidForInvalidCSV() {
        String[] header = { "foo", "bar", "foobar" };
        String[] row1 = { "FOO1", "BAR1", "FOOBAR1" };
        String[] row2 = { "FOO2", "BAR2" };
        String[] row3 = { "FOO3", "BAR3", "FOOBAR3" };
        List<String[]> csv = new ArrayList<>();
        csv.add(header);
        csv.add(row1);
        csv.add(row2);
        csv.add(row3);

        assertFalse(reader.isValid(csv));
    }
}
