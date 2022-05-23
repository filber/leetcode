package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _474_OnesAndZeroesTest {

    _474_OnesAndZeroes target = null;

    @Before
    public void before() throws Exception {
        target = new _474_OnesAndZeroes();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindMaxForm1() throws Exception {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        //{"10", "0001", "1", "0"}
        int maxLen = target.findMaxForm(strs, m, n);
        assertEquals(4, maxLen);
    }

    @Test
    public void testFindMaxForm2() throws Exception {
        String[] strs = {"10", "0", "1"};
        int m = 1;
        int n = 1;
        //{"0","1"}
        int maxLen = target.findMaxForm(strs, m, n);
        assertEquals(2, maxLen);
    }

    @Test
    public void testFindMaxForm3() throws Exception {
        String[] strs = {"10"};
        int m = 1;
        int n = 1;
        //{"10"}
        int maxLen = target.findMaxForm(strs, m, n);
        assertEquals(1, maxLen);
    }

    @Test
    public void testFindMaxForm4() throws Exception {
        String[] strs = {"100"};
        int m = 1;
        int n = 1;
        //{}
        int maxLen = target.findMaxForm(strs, m, n);
        assertEquals(0, maxLen);
    }

    @Test
    public void testFindMaxForm5() throws Exception {
        String[] strs = {"100"};
        int m = 1;
        int n = 2;
        //{}
        int maxLen = target.findMaxForm(strs, m, n);
        assertEquals(0, maxLen);
    }

    @Test
    public void testFindMaxForm6() throws Exception {
        String[] strs = {"100"};
        int m = 2;
        int n = 2;
        //{"100"}
        int maxLen = target.findMaxForm(strs, m, n);
        assertEquals(1, maxLen);
    }

    @Test
    public void testFindMaxForm7() throws Exception {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 3;
        int n = 4;
        //{"10", "1", "0"}
        int maxLen = target.findMaxForm(strs, m, n);
        assertEquals(3, maxLen);
    }

    @Test
    public void testFindMaxForm8() throws Exception {
        String[] strs = {"111","1000","1000","1000"};
        int m = 9;
        int n = 3;
        //{"1000","1000","1000"}
        int maxLen = target.findMaxForm(strs, m, n);
        assertEquals(3, maxLen);
    }
}
