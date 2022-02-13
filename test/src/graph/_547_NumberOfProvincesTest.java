package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _547_NumberOfProvincesTest {

    _547_NumberOfProvinces target = null;

    @Before
    public void before() throws Exception {
        target = new _547_NumberOfProvinces();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindCircleNumOne() throws Exception {
        int n = target.findCircleNum(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1},
        });
        assertEquals(1, n);
    }

    @Test
    public void testFindCircleNumTwo() throws Exception {
        int n = target.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}});
        assertEquals(2, n);
    }

    @Test
    public void testFindCircleNumTwo2() throws Exception {
        int n = target.findCircleNum(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
        });
        assertEquals(2, n);
    }

    @Test
    public void testFindCircleNumThree() throws Exception {
        int n = target.findCircleNum(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}});
        assertEquals(3, n);
    }

    @Test
    public void testFindCircleNumThree2() throws Exception {
        int n = target.findCircleNum(new int[][]{
                {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}
        });
        assertEquals(3, n);
    }
}
