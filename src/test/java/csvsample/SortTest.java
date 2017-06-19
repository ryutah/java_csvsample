package csvsample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SortTest {
    @Test
    public void testBableSort() {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(94, 2, 128, 4, 44, 28, 23));

        List<Integer> want = new ArrayList<>();
        want.addAll(Arrays.asList(2, 4, 23, 28, 44, 94, 128));

        Sort.bubleSort(list, (a, b) -> a - b);
        assertThat(list, is(want));
    }
}
