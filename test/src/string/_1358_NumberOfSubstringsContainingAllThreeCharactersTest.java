package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1358_NumberOfSubstringsContainingAllThreeCharactersTest {

    _1358_NumberOfSubstringsContainingAllThreeCharacters target = null;

    @Before
    public void before() throws Exception {
        target = new _1358_NumberOfSubstringsContainingAllThreeCharacters();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testNumberOfSubstrings1() throws Exception {
        int n = target.numberOfSubstrings("aaa");
        assertEquals(0, n);
    }

    @Test
    public void testNumberOfSubstrings2() throws Exception {
        int n = target.numberOfSubstrings("aab");
        assertEquals(0, n);
    }

    @Test
    public void testNumberOfSubstrings3() throws Exception {
        int n = target.numberOfSubstrings("abc");
        assertEquals(1, n);
    }

    @Test
    public void testNumberOfSubstrings4() throws Exception {
        int n = target.numberOfSubstrings("aaacb");
        assertEquals(3, n);
    }

    @Test
    public void testNumberOfSubstrings5() throws Exception {
        int n = target.numberOfSubstrings("abcabc");
        assertEquals(10, n);
    }
}
