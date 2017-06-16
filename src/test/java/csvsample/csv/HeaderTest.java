package csvsample.csv;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HeaderTest {

    @Test
    public void testIndex() {
        Header header = new Header("foo", "bar", "foobar");
        assertThat(header.index("foobar").get(), is(2));
    }
}
