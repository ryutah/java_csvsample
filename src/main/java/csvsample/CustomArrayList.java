package csvsample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomArrayList<T> extends ArrayList<T> {
    private static final long serialVersionUID = 1L;

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
