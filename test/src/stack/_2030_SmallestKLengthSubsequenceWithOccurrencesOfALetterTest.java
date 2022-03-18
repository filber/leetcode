package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2030_SmallestKLengthSubsequenceWithOccurrencesOfALetterTest {

    _2030_SmallestKLengthSubsequenceWithOccurrencesOfALetter target = null;

    @Before
    public void before() throws Exception {
        target = new _2030_SmallestKLengthSubsequenceWithOccurrencesOfALetter();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSmallestSubsequence1() throws Exception {
        String str = target.smallestSubsequence("leet", 3, 'e', 2);
        assertEquals("eet", str);
    }

    @Test
    public void testSmallestSubsequence2() throws Exception {
        String str = target.smallestSubsequence("leetcode", 4, 'e', 2);
        assertEquals("ecde", str);
    }

    @Test
    public void testSmallestSubsequence3() throws Exception {
        String str = target.smallestSubsequence("bb", 2, 'b', 2);
        assertEquals("bb", str);
    }
}
