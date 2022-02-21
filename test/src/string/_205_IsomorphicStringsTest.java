package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _205_IsomorphicStringsTest {

    _205_IsomorphicStrings target = null;

    @Before
    public void before() throws Exception {
        target = new _205_IsomorphicStrings();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsIsomorphic1() throws Exception {
        boolean is = target.isIsomorphic("egg", "add");
        assertTrue(is);
    }

    @Test
    public void testIsIsomorphic2() throws Exception {
        boolean is = target.isIsomorphic("foo", "bar");
        assertFalse(is);
    }

    @Test
    public void testIsIsomorphic3() throws Exception {
        boolean is = target.isIsomorphic("bar", "foo");
        assertFalse(is);
    }

    @Test
    public void testIsIsomorphic4() throws Exception {
        boolean is = target.isIsomorphic("paper", "title");
        assertTrue(is);
    }
}
