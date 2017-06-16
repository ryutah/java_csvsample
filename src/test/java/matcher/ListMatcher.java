package matcher;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class ListMatcher {
    private static class LMatcher<T> extends TypeSafeDiagnosingMatcher<List<? super T>> {
        @Override
        protected boolean matchesSafely(List<? super T> collection, Description mismatchDescription) {
            return false;

        }

        @Override
        public void describeTo(Description description) {
            // TODO Auto-generated method stub
            Arrays.asList(1, 2, 3);
        }
    }

    public static <T> Matcher<List<? super T>> completeMatch(T... values) {
        return new LMatcher<T>();
    }
}
