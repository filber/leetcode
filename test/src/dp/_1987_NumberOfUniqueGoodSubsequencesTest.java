package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1987_NumberOfUniqueGoodSubsequencesTest {

    _1987_NumberOfUniqueGoodSubsequences target = null;

    @Before
    public void before() throws Exception {
        target = new _1987_NumberOfUniqueGoodSubsequences();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testNumberOfUniqueGoodSubsequences1() throws Exception {
        int num = target.numberOfUniqueGoodSubsequences("001");
        // ["0","1"]
        assertEquals(2, num);
    }

    @Test
    public void testNumberOfUniqueGoodSubsequences2() throws Exception {
        int num = target.numberOfUniqueGoodSubsequences("11");
        // ["1","11"]
        assertEquals(2, num);
    }

    @Test
    public void testNumberOfUniqueGoodSubsequences3() throws Exception {
        int num = target.numberOfUniqueGoodSubsequences("101");
        // ["0","1","10","11","101"]
        assertEquals(5, num);
    }
}