package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _820_ShortEncodingOfWordsTest {

    _820_ShortEncodingOfWords target = null;

    @Before
    public void before() throws Exception {
        target = new _820_ShortEncodingOfWords();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinimumLengthEncoding1() throws Exception {
        String[] words = {"time", "me", "bell"};
        int len = target.minimumLengthEncoding(words);
        assertEquals(10, len);
    }

    @Test
    public void testMinimumLengthEncoding2() throws Exception {
        String[] words = {"t"};
        int len = target.minimumLengthEncoding(words);
        assertEquals(2, len);
    }
}
