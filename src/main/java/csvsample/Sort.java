package csvsample;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static <T> void bubleSort(List<T> list, Comparator<T> condition) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i; j < list.size(); j++) {
                if (condition.compare(list.get(i), list.get(j)) > 0)
                    Collections.swap(list, i, j);
            }
        }
    }
}
