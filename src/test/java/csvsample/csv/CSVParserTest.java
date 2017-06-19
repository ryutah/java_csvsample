package csvsample.csv;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class CSVParserTest {
    public static class Foo {
        @Column(name = "foo")
        public String  foo;

        @Column(name = "bar")
        public Integer bar;

        @Column(name = "foofoo")
        private int    foofoo;

        @Column(name = "foobar")
        private String foobar;

        @Column(name = "nocolmn")
        private String nocolmn;

        public Foo() {
        }

        public Foo(String foo, Integer bar, int foofoo, String foobar) {
            this.foo = foo;
            this.bar = bar;
            this.foofoo = foofoo;
            this.foobar = foobar;
        }
    }

    @Test
    public void testParseString() {
        String str = "foo,bar,foofoo,foobar\n" +
                "FOO1,1,10,FOOBAR1\n" +
                "FOO2,2,20,FOOBAR2\n";
        List<Foo> foos = CSVParser.parse(str, Foo.class);

        assertThat(foos.size(), is(2));
        assertFoo(foos.get(0), new Foo("FOO1", 1, 10, "FOOBAR1"));
        assertFoo(foos.get(1), new Foo("FOO2", 2, 20, "FOOBAR2"));
    }

    private void assertFoo(Foo want, Foo got) {
        assertThat(got.foo, is(want.foo));
        assertThat(got.bar, is(want.bar));
        assertThat(got.foofoo, is(want.foofoo));
        assertThat(got.foobar, is(want.foobar));
    }
}
