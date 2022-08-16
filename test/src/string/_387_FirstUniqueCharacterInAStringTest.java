package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _387_FirstUniqueCharacterInAStringTest {

    _387_FirstUniqueCharacterInAString target = null;

    @Before
    public void before() throws Exception {
        target = new _387_FirstUniqueCharacterInAString();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFirstUniqChar1() throws Exception {
        int idx = target.firstUniqChar("leetcode");
        assertEquals(0, idx);
    }

    @Test
    public void testFirstUniqChar2() throws Exception {
        int idx = target.firstUniqChar("loveleetcode");
        assertEquals(2, idx);
    }

    @Test
    public void testFirstUniqChar3() throws Exception {
        int idx = target.firstUniqChar("aabb");
        assertEquals(-1, idx);
    }
}
