package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _796_RotateStringTest {

    _796_RotateString target = null;

    @Before
    public void before() throws Exception {
        target = new _796_RotateString();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRotateString1() throws Exception {
        boolean equal = target.rotateString("abcde", "cdeab");
        assertEquals(true, equal);
    }

    @Test
    public void testRotateString2() throws Exception {
        boolean equal = target.rotateString("abcde", "abced");
        assertEquals(false, equal);
    }
}
