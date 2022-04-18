package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _767_ReorganizeStringTest {

    _767_ReorganizeString target = null;

    @Before
    public void before() throws Exception {
        target = new _767_ReorganizeString();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testReorganizeString1() throws Exception {
        String str = target.reorganizeString("aab");
        assertEquals("aba", str);
    }

    @Test
    public void testReorganizeString2() throws Exception {
        String str = target.reorganizeString("aaab");
        assertEquals("", str);
    }

    @Test
    public void testReorganizeString3() throws Exception {
        String str = target.reorganizeString("aabbccdd");
        assertEquals("adcbabcd", str);
    }
}
