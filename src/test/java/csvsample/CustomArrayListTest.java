package csvsample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

import org.junit.Test;

public class CustomArrayListTest {
    @Test
    public void testQuickSort() {
        CustomArrayList<Integer> ints = new CustomArrayList<>();
        ints.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Collections.shuffle(ints);

        ints.quickSort((a, b) -> a - b);
        IntStream.rangeClosed(0, 9).forEach(i -> assertThat(ints.get(i), is(i + 1)));
    }

    @Test
    public void testMergeSort() {
        CustomArrayList<Integer> ints = new CustomArrayList<>();
        ints.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Collections.shuffle(ints);

        ints.mergeSort((a, b) -> a - b);
        IntStream.rangeClosed(0, 9).forEach(i -> assertThat(ints.get(i), is(i + 1)));
    }
}
