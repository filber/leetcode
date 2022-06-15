package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1048_LongestStringChainTest {

    _1048_LongestStringChain target = null;

    @Before
    public void before() throws Exception {
        target = new _1048_LongestStringChain();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLongestStrChain1() throws Exception {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        int len = target.longestStrChain(words);
        assertEquals(4, len);
    }

    @Test
    public void testLongestStrChain2() throws Exception {
        String[] words = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        int len = target.longestStrChain(words);
        assertEquals(5, len);
    }

    @Test
    public void testLongestStrChain3() throws Exception {
        String[] words = {"abcd", "dbqca"};
        int len = target.longestStrChain(words);
        assertEquals(1, len);
    }
}
