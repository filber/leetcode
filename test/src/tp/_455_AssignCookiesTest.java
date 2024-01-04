package tp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _455_AssignCookiesTest {

    _455_AssignCookies target;

    @Before
    public void setUp() throws Exception {
        target = new _455_AssignCookies();
    }

    @Test
    public void testFindContentChildren1() {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        int content = target.findContentChildren(g, s);
        assertEquals(1, content);
    }

    @Test
    public void testFindContentChildren2() {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};
        int content = target.findContentChildren(g, s);
        assertEquals(2, content);
    }
}