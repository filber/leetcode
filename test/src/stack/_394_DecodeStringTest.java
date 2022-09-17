package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _394_DecodeStringTest {

    _394_DecodeString target = null;

    @Before
    public void before() throws Exception {
        target = new _394_DecodeString();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testDecodeString1() throws Exception {
        String decoded = target.decodeString("3[a]2[bc]");
        assertEquals("aaabcbc", decoded);
    }

    @Test
    public void testDecodeString2() throws Exception {
        String decoded = target.decodeString("3[a2[c]]");
        assertEquals("accaccacc", decoded);
    }

    @Test
    public void testDecodeString3() throws Exception {
        String decoded = target.decodeString("2[abc]3[cd]ef");
        assertEquals("abcabccdcdcdef", decoded);
    }

    @Test
    public void testDecodeString4() throws Exception {
        String decoded = target.decodeString("10[leetcode]");
        assertEquals("leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode", decoded);
    }
}
