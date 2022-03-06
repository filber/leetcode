package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1312_MinimumInsertionStepsToMakeAStringPalindromeTest {

    _1312_MinimumInsertionStepsToMakeAStringPalindrome target = null;

    @Before
    public void before() throws Exception {
        target = new _1312_MinimumInsertionStepsToMakeAStringPalindrome();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinInsertions1() throws Exception {
        int insertions = target.minInsertions("zzazz");
        assertEquals(0, insertions);
    }

    @Test
    public void testMinInsertions2() throws Exception {
        // "mbdadbm","mdbabdm"
        int insertions = target.minInsertions("mbadm");
        assertEquals(2, insertions);
    }

    @Test
    public void testMinInsertions3() throws Exception {
        // "leetcodocteel"
        int insertions = target.minInsertions("leetcode");
        assertEquals(5, insertions);
    }

} 
