package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _97_InterleavingStringTest {

    _97_InterleavingString target = null;

    @Before
    public void before() throws Exception {
        target = new _97_InterleavingString();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIsInterleave1() throws Exception {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean is = target.isInterleave(s1, s2, s3);
        assertTrue(is);
    }

    @Test
    public void testIsInterleave2() throws Exception {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        boolean is = target.isInterleave(s1, s2, s3);
        assertFalse(is);
    }

    @Test
    public void testIsInterleave3() throws Exception {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        boolean is = target.isInterleave(s1, s2, s3);
        assertTrue(is);
    }
}