package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _85_MaximalRectangleTest {

    _85_MaximalRectangle target = null;

    @Before
    public void before() throws Exception {
        target = new _85_MaximalRectangle();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMaximalRectangle1() throws Exception {
        int area = target.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}});
        assertEquals(6, area);
    }

    @Test
    public void testMaximalRectangle2() throws Exception {
        int area = target.maximalRectangle(new char[][]{
                {'0'}});
        assertEquals(0, area);
    }

    @Test
    public void testMaximalRectangle3() throws Exception {
        int area = target.maximalRectangle(new char[][]{
                {'1'}});
        assertEquals(1, area);
    }

    @Test
    public void testMaximalRectangle4() throws Exception {
        int area = target.maximalRectangle(new char[][]{
                {'0', '1'},
                {'1', '0'}});
        assertEquals(1, area);
    }
}
