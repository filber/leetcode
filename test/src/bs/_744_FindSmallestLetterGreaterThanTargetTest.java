package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _744_FindSmallestLetterGreaterThanTargetTest {

    _744_FindSmallestLetterGreaterThanTarget target = null;

    @Before
    public void before() throws Exception {
        target = new _744_FindSmallestLetterGreaterThanTarget();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNextGreatestLetter1() throws Exception {
        char ch = target.nextGreatestLetter(new char[]{'a', 'b'}, 'z');
        assertEquals('a', ch);
    }

    @Test
    public void testNextGreatestLetter2() throws Exception {
        char ch = target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a');
        assertEquals('c', ch);
    }

    @Test
    public void testNextGreatestLetter3() throws Exception {
        char ch = target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c');
        assertEquals('f', ch);
    }

    @Test
    public void testNextGreatestLetter4() throws Exception {
        char ch = target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd');
        assertEquals('f', ch);
    }

    @Test
    public void testNextGreatestLetter5() throws Exception {
        char ch = target.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'h');
        assertEquals('j', ch);
    }

    @Test
    public void testNextGreatestLetter6() throws Exception {
        char ch = target.nextGreatestLetter(new char[]{'c', 'f', 'f', 'f', 'f', 'f', 'j'}, 'h');
        assertEquals('j', ch);
    }
}