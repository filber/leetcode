package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _456_132PatternTest {

    _456_132Pattern target = null;

    @Before
    public void before() throws Exception {
        target = new _456_132Pattern();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFind132pattern1() throws Exception {
        boolean rst = target.find132pattern(new int[]{1, 2, 3, 4});
        assertFalse(rst);
    }

    @Test
    public void testFind132pattern2() throws Exception {
        boolean rst = target.find132pattern(new int[]{3, 1, 4, 2});
        assertTrue(rst);
    }

    @Test
    public void testFind132pattern3() throws Exception {
        boolean rst = target.find132pattern(new int[]{-1, 3, 2, 0});
        assertTrue(rst);
    }

    @Test
    public void testFind132pattern4() throws Exception {
        boolean rst = target.find132pattern(new int[]{3, 5, 0, 3, 4});
        assertTrue(rst);
    }

    @Test
    public void testFind132pattern5() throws Exception {
        boolean rst = target.find132pattern(new int[]{10, 3, 5, 0, 3, 4});
        assertTrue(rst);
    }

    @Test
    public void testFind132pattern6() throws Exception {
        boolean rst = target.find132pattern(new int[]{-2, 1, 2, -2, 1, 2});
        assertTrue(rst);
    }

    @Test
    public void testFind132pattern7() throws Exception {
        boolean rst = target.find132pattern(new int[]{-2, 1});
        assertFalse(rst);
    }

    @Test
    public void testFind132pattern8() throws Exception {
        boolean rst = target.find132pattern(new int[]{2, 1});
        assertFalse(rst);
    }

    @Test
    public void testFind132pattern9() throws Exception {
        boolean rst = target.find132pattern(new int[]{1});
        assertFalse(rst);
    }

    @Test
    public void testFind132pattern10() throws Exception {
        boolean rst = target.find132pattern(new int[]{3, 4, -4, -3, -5, -1});
        assertFalse(rst);
    }

    @Test
    public void testFind132pattern11() throws Exception {
        boolean rst = target.find132pattern(new int[]{-2, 1, 1});
        assertFalse(rst);
    }
}
