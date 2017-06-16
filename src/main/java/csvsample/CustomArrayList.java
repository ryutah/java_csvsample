package csvsample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.IntStream;

public class CustomArrayList<T> extends ArrayList<T> {
    private static final long serialVersionUID = 1L;

    public void mergeSort(Comparator<T> condition) {
        CustomArrayList<T> newList = mSort(condition);
        this.clear();
        this.addAll(newList);
    }

    public CustomArrayList<T> mSort(Comparator<T> condition) {
        if (this.size() <= 1) {
            return this;
        }

        int mid = this.size() / 2;
        CustomArrayList<T> left = createNewListByRange(0, mid);
        CustomArrayList<T> right = createNewListByRange(mid, this.size() - 1);
        left.mergeSort(condition);
        right.mergeSort(condition);

        return left.merge(right, condition);
    }

    private CustomArrayList<T> createNewListByRange(int rangeStart, int rangeEnd) {
        return IntStream.range(rangeStart, rangeEnd)
                        .mapToObj(i -> this.get(i))
                        .collect(() -> new CustomArrayList<>(),
                                 (list, val) -> list.add(val),
                                 (a, b) -> a.addAll(b));
    }

    private CustomArrayList<T> merge(CustomArrayList<T> other, Comparator<T> condition) {
        CustomArrayList<T> result = new CustomArrayList<T>();
        for (int i = 0, j = 0; i < this.size() || j < other.size();) {
            if (i < this.size() && condition.compare(this.get(i), other.get(j)) < 0) {
                result.set(i + j, this.get(i));
                i++;
            } else {
                result.set(i + j, other.get(j));
                j++;
            }
        }
        return result;
    }

    public void quickSort(Comparator<T> condition) {
        quickSort(condition, 0, this.size() - 1);
    }

    private void quickSort(Comparator<T> condition, int cursorBegin, int cursorEnd) {
        if (cursorBegin >= cursorEnd) {
            return;
        }

        T pivot = pivot(cursorBegin, cursorEnd);
        int cursorLeft = cursorBegin;
        int cursorRight = cursorEnd;
        while (cursorLeft <= cursorRight) {
            while (condition.compare(this.get(cursorLeft), pivot) < 0)
                cursorLeft++;
            while (condition.compare(this.get(cursorRight), pivot) > 0)
                cursorRight--;
            if (cursorLeft <= cursorRight) {
                Collections.swap(this, cursorLeft, cursorRight);
                cursorLeft++;
                cursorRight--;
            }
        }

        this.quickSort(condition, cursorBegin, cursorRight);
        this.quickSort(condition, cursorLeft, cursorEnd);
    }

    private T pivot(int cursorBegin, int cursorEnd) {
        return this.get(cursorBegin);
    }
}
