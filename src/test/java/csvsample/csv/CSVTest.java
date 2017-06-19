package csvsample.csv;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import csvsample.reader.CSVReader;
import csvsample.reader.StringCSVReader;

public class CSVTest {
    private CSV csv;

    @Before
    public void createCSV() {
        String str = "foo,bar,foobar\n" +
                "FOO,BAR,FOOBAR\n" +
                "FOO2,BAR2,FOOBAR2";
        CSVReader reader = new StringCSVReader(str);
        this.csv = new CSV(reader);
    }

    @Test
    public void testHeader() {
        assertThat(this.csv.header().header(0).get(), is("foo"));
        assertThat(this.csv.header().header(1).get(), is("bar"));
        assertThat(this.csv.header().header(2).get(), is("foobar"));
        assertFalse(this.csv.header().header(3).isPresent());
    }

    @Test
    public void testRow() {
        assertThat(this.csv.row(0).get().column("foo").get(), is("FOO"));
        assertThat(this.csv.row(1).get().column("foo").get(), is("FOO2"));
        assertFalse(this.csv.row(2).isPresent());
    }
}
