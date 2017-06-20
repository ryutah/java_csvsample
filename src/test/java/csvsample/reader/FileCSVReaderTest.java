package csvsample.reader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class FileCSVReaderTest {
    @Test
    public void testRead() {
        CSVReader reader = new FileCSVReader(ClassLoader.getSystemResource("test.csv").getFile());
        List<String[]> csv = reader.read();
        assertThat(csv.size(), is(10));
        assertThat(csv.get(1), is(new String[] { "033122", "トラッシュ太郎", "M", "あーりん", "4", "26", "ffffff82" }));
    }
}
