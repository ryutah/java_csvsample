package csvsample.csv;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RowTest {
    private Header header;
    private Row row;

    @Before
    public void createHeader() {
        this.header = new Header("foo", "bar", "foobar");
        this.row = new Row(this.header, "FOO", "BAR", "FOOBAR");
    }

    @Test
    public void testColumnGivenName() {
        assertThat(this.row.column("bar").get(), is("BAR"));
    }

    @Test
    public void testColumnGivenUnexistsName() {
        assertThat(this.row.column("hogehoge").isPresent(), is(false));
    }

    @Test
    public void testColumnGivenIndex() {
        assertThat(this.row.column(2).get(), is("FOOBAR"));
    }

    @Test
    public void testColumnGivenOverIndex() {
        assertThat(this.row.column(2).get(), is("FOOBAR"));
    }
}
