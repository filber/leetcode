package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _823_BinaryTreesWithFactorsTest {

    _823_BinaryTreesWithFactors target = null;

    @Before
    public void before() throws Exception {
        target = new _823_BinaryTreesWithFactors();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumFactoredBinaryTrees1() throws Exception {
        int cnt = target.numFactoredBinaryTrees(new int[]{2, 4});
        assertEquals(3, cnt);
    }

    @Test
    public void testNumFactoredBinaryTrees2() throws Exception {
        int cnt = target.numFactoredBinaryTrees(new int[]{2, 4, 5, 10});
        assertEquals(7, cnt);
    }

    @Test
    public void testNumFactoredBinaryTrees3() throws Exception {
        int cnt = target.numFactoredBinaryTrees(new int[]{45, 42, 2, 18, 23, 1170, 12, 41, 40, 9, 47, 24, 33, 28, 10, 32, 29, 17, 46, 11, 759, 37, 6, 26, 21, 49, 31, 14, 19, 8, 13, 7, 27, 22, 3, 36, 34, 38, 39, 30, 43, 15, 4, 16, 35, 25, 20, 44, 5, 48});
        assertEquals(777, cnt);
    }
} 
