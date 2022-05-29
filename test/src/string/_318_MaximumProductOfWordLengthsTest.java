package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _318_MaximumProductOfWordLengthsTest {

    _318_MaximumProductOfWordLengths target = null;

    @Before
    public void before() throws Exception {
        target = new _318_MaximumProductOfWordLengths();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxProduct1() throws Exception {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        // "abcw" vs "xtfn"
        int product = target.maxProduct(words);
        assertEquals(16, product);
    }

    @Test
    public void testMaxProduct2() throws Exception {
        String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        // "ab" vs "cd"
        int product = target.maxProduct(words);
        assertEquals(4, product);
    }

    @Test
    public void testMaxProduct3() throws Exception {
        String[] words = {"a", "aa", "aaa", "aaaa"};
        int product = target.maxProduct(words);
        assertEquals(0, product);
    }
}
