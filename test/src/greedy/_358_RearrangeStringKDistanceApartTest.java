package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _358_RearrangeStringKDistanceApartTest {

    _358_RearrangeStringKDistanceApart target = null;

    @Before
    public void before() throws Exception {
        target = new _358_RearrangeStringKDistanceApart();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRearrangeString1() throws Exception {
        String str = target.rearrangeString("aabbcc", 3);
        assertEquals("abcabc", str);
    }

    @Test
    public void testRearrangeString2() throws Exception {
        String str = target.rearrangeString("aaabc", 3);
        assertEquals("", str);
    }

    @Test
    public void testRearrangeString3() throws Exception {
        String str = target.rearrangeString("aaabc", 2);
        assertEquals("abaca", str);
    }

    @Test
    public void testRearrangeString4() throws Exception {
        String str = target.rearrangeString("aaadbbcc", 2);
        assertEquals("abacabcd", str);
    }
}
