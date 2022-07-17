package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _629_KInversePairsArrayTest {

    _629_KInversePairsArray target = null;

    @Before
    public void before() throws Exception {
        target = new _629_KInversePairsArray();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testKInversePairs1() throws Exception {
        int n = 3;
        int k = 0;
        int count = target.kInversePairs(n, k);
        assertEquals(1, count);
    }

    @Test
    public void testKInversePairs2() throws Exception {
        int n = 3;
        int k = 1;
        int count = target.kInversePairs(n, k);
        assertEquals(2, count);
    }
}
