package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _844_BackspaceStringCompareTest {

    _844_BackspaceStringCompare target = null;

    @Before
    public void before() throws Exception {
        target = new _844_BackspaceStringCompare();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testBackspaceCompare1() throws Exception {
        boolean equals = target.backspaceCompare("ab#c", "ad#c");
        assertTrue(equals);
    }

    @Test
    public void testBackspaceCompare2() throws Exception {
        boolean equals = target.backspaceCompare("ab##", "c#d#");
        assertTrue(equals);
    }

    @Test
    public void testBackspaceCompare6() throws Exception {
        boolean equals = target.backspaceCompare("ab###", "c#d#");
        assertTrue(equals);
    }

    @Test
    public void testBackspaceCompare7() throws Exception {
        boolean equals = target.backspaceCompare("abc###", "c#d#");
        assertTrue(equals);
    }

    @Test
    public void testBackspaceCompare3() throws Exception {
        boolean equals = target.backspaceCompare("ab##f", "c#d#e");
        assertFalse(equals);
    }

    @Test
    public void testBackspaceCompare4() throws Exception {
        boolean equals = target.backspaceCompare("a#c", "b");
        assertFalse(equals);
    }

    @Test
    public void testBackspaceCompare5() throws Exception {
        boolean equals = target.backspaceCompare("a#c", "c");
        assertTrue(equals);
    }

    @Test
    public void testBackspaceCompare8() throws Exception {
        boolean equals = target.backspaceCompare("bbbextm", "bbb#extm");
        assertFalse(equals);
    }

    @Test
    public void testBackspaceCompare9() throws Exception {
        boolean equals = target.backspaceCompare("nzp#o#g", "b#nzp#o#g");
        assertTrue(equals);
    }
}
