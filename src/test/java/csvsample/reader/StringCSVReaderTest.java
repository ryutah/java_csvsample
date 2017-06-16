package csvsample.reader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class StringCSVReaderTest {

    @Test
    public void testRead() {
        StringBuilder builder = new StringBuilder();
        builder.append("foo,bar,foobar\n")
               .append("FOO1,BAR1,FOOBAR1\n")
               .append("FOO2,BAR2,FOOBAR2\n")
               .append("FOO3,BAR3,FOOBAR3\n")
               .append("FOO4,BAR4,FOOBAR4\n")
               .append("FOO5,BAR5,FOOBAR5\n");
        StringCSVReader reader = new StringCSVReader(builder.toString());
        List<String[]> got = reader.read();
        String[] want = { "FOO3", "BAR3", "FOOBAR3" };
        assertThat(got.size(), is(6));
        assertThat(got.get(3), is(want));
    }
}
