package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tree._715_RangeModule.*;

import static org.junit.Assert.*;

public class _715_RangeModuleTest {

    RangeModule target = null;

    @Before
    public void before() throws Exception {
        target = new STRangeModule();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testRangeAddRange1() throws Exception {
        target.addRange(10, 20);
        target.addRange(21, 30);

        int[][] ranges = target.ranges();
        assertArrayEquals(new int[][]{{10, 20}, {21, 30}}, ranges);
    }

    @Test
    public void testRangeAddRange2() throws Exception {
        target.addRange(10, 20);
        target.addRange(20, 30);

        int[][] ranges = target.ranges();
//        assertArrayEquals(new int[][]{{10, 30}}, ranges);
        assertArrayEquals(new int[][]{{10, 20}, {20, 30}}, ranges);
    }

    @Test
    public void testRangeAddRange3() throws Exception {
        target.addRange(10, 20);
        target.addRange(10, 19);

        int[][] ranges = target.ranges();
        assertArrayEquals(new int[][]{{10, 20}}, ranges);
    }

    @Test
    public void testRangeAddRange4() throws Exception {
        target.addRange(10, 20);
        target.addRange(1, 5);

        int[][] ranges = target.ranges();
        assertArrayEquals(new int[][]{{1, 5}, {10, 20}}, ranges);
    }

    @Test
    public void testRangeAddRange5() throws Exception {
        target.addRange(10, 20);
        target.addRange(1, 30);

        int[][] ranges = target.ranges();
//        assertArrayEquals(new int[][]{{1, 30}}, ranges);
        assertArrayEquals(new int[][]{{1, 10}, {10, 20}, {20, 30}}, ranges);
    }

    @Test
    public void testRangeAddRange6() throws Exception {
        target.addRange(10, 20);
        target.addRange(1, 15);

        int[][] ranges = target.ranges();
//        assertArrayEquals(new int[][]{{1, 20}}, ranges);
        assertArrayEquals(new int[][]{{1, 10}, {10, 20}}, ranges);
    }


    @Test
    public void testRangeQueryRange1() throws Exception {
        target.addRange(10, 20);
        assertTrue(target.queryRange(12, 19));
    }

    @Test
    public void testRangeQueryRange2() throws Exception {
        target.addRange(10, 20);
        assertFalse(target.queryRange(1, 19));
    }

    @Test
    public void testRangeQueryRange3() throws Exception {
        target.addRange(10, 20);
        assertFalse(target.queryRange(15, 21));
    }

    @Test
    public void testRangeQueryRange4() throws Exception {
        target.addRange(10, 20);
        target.addRange(1, 6);
        boolean rst = target.queryRange(7, 9);
        assertFalse(rst);
    }

    @Test
    public void testRangeRemoveRange1() throws Exception {
        target.addRange(10, 20);
        target.removeRange(25, 30);

        int[][] ranges = target.ranges();
        assertArrayEquals(new int[][]{{10, 20}}, ranges);
    }

    @Test
    public void testRangeRemoveRange2() throws Exception {
        target.addRange(10, 20);
        target.removeRange(10, 30);
        assertEquals(0, target.ranges().length);

        target.addRange(10, 20);
        target.removeRange(15, 30);
        int[][] ranges = target.ranges();
        assertArrayEquals(new int[][]{{10, 15}}, ranges);
    }

    @Test
    public void testRangeRemoveRange3() throws Exception {
        target.addRange(10, 20);
        target.removeRange(10, 20);
        assertEquals(0, target.ranges().length);

        target.addRange(10, 20);
        target.removeRange(15, 20);
        assertArrayEquals(new int[][]{{10, 15}}, target.ranges());

        target.addRange(10, 20);
        target.removeRange(10, 15);
        assertArrayEquals(new int[][]{{15, 20}}, target.ranges());

        target.addRange(10, 20);
        target.removeRange(15, 17);
        assertArrayEquals(new int[][]{{10, 15}, {17, 20}}, target.ranges());
    }


    @Test
    public void testRangeRemoveRange4() throws Exception {
        target.addRange(10, 20);
        target.removeRange(1, 10);
        assertArrayEquals(new int[][]{{10, 20}}, target.ranges());
    }

    @Test
    public void testRangeRemoveRange5() throws Exception {
        target.addRange(10, 20);
        target.addRange(25, 30);
        target.removeRange(5, 30);
        assertEquals(0, target.ranges().length);
    }

    @Test
    public void testRangeRemoveRange6() throws Exception {
        target.addRange(10, 20);
        target.addRange(25, 30);
        target.removeRange(15, 27);

        assertArrayEquals(new int[][]{{10, 15}, {27, 30}}, target.ranges());
    }

    @Test
    public void testRangeModule1() throws Exception {
        target.addRange(10, 20);  // [10,20)
        target.removeRange(14, 16); // [10,14),[16,20)
        assertTrue(target.queryRange(10, 14));
        assertFalse(target.queryRange(13, 15));
        assertTrue(target.queryRange(16, 17));
    }

    @Test
    public void testRangeModule2() throws Exception {
        target.addRange(10, 180);  // [10,180)
        target.addRange(150, 200);  // [10,200)
        target.addRange(250, 500);  // [10,200),[250,500)

        assertTrue(target.queryRange(50, 100));
        assertFalse(target.queryRange(180, 300));
        assertFalse(target.queryRange(600, 1000));

        target.removeRange(50, 150);  // [10,50),[150,200),[250,500)
        assertFalse(target.queryRange(50, 100));
    }
}
