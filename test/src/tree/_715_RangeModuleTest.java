package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tree._715_RangeModule.*;

import static org.junit.Assert.*;

public class _715_RangeModuleTest {

    TMRangeModule target = null;

    @Before
    public void before() throws Exception {
        target = new TMRangeModule();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testRangeAddRange1() throws Exception {
        target.addRange(10, 20);
        target.addRange(21, 30);
        assertEquals(2, target.treeMap.size());
    }

    @Test
    public void testRangeAddRange2() throws Exception {
        target.addRange(10, 20);
        target.addRange(20, 30);
        assertEquals(1, target.treeMap.size());
        assertEquals(30, target.treeMap.get(10).intValue());
    }

    @Test
    public void testRangeAddRange3() throws Exception {
        target.addRange(10, 20);
        target.addRange(10, 19);
        assertEquals(1, target.treeMap.size());
        assertEquals(20, target.treeMap.get(10).intValue());
    }

    @Test
    public void testRangeAddRange4() throws Exception {
        target.addRange(10, 20);
        target.addRange(1, 5);
        assertEquals(2, target.treeMap.size());
    }

    @Test
    public void testRangeAddRange5() throws Exception {
        target.addRange(10, 20);
        target.addRange(1, 30);
        assertEquals(1, target.treeMap.size());
        assertEquals(30, target.treeMap.get(1).intValue());
    }

    @Test
    public void testRangeAddRange6() throws Exception {
        target.addRange(10, 20);
        target.addRange(1, 15);
        assertEquals(1, target.treeMap.size());
        assertEquals(20, target.treeMap.get(1).intValue());
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
    public void testRangeRemoveRange1() throws Exception {
        target.addRange(10, 20);
        target.removeRange(25, 30);
        assertEquals(1, target.treeMap.size());
    }

    @Test
    public void testRangeRemoveRange2() throws Exception {
        target.addRange(10, 20);
        target.removeRange(10, 30);
        assertEquals(0, target.treeMap.size());

        target.addRange(10, 20);
        target.removeRange(15, 30);
        assertEquals(1, target.treeMap.size());
        assertEquals(15, target.treeMap.get(10).intValue());
    }

    @Test
    public void testRangeRemoveRange3() throws Exception {
        target.addRange(10, 20);
        target.removeRange(10, 20);
        assertTrue(target.treeMap.isEmpty());

        target.addRange(10, 20);
        target.removeRange(15, 20);
        assertEquals(15, target.treeMap.get(10).intValue());

        target.addRange(10, 20);
        target.removeRange(10, 15);
        assertEquals(20, target.treeMap.get(15).intValue());

        target.addRange(10, 20);
        target.removeRange(15, 17);
        assertEquals(15, target.treeMap.get(10).intValue());
        assertEquals(20, target.treeMap.get(17).intValue());
    }


    @Test
    public void testRangeRemoveRange4() throws Exception {
        target.addRange(10, 20);
        target.removeRange(1, 10);
        assertEquals(1, target.treeMap.size());
    }

    @Test
    public void testRangeRemoveRange5() throws Exception {
        target.addRange(10, 20);
        target.addRange(25, 30);
        target.removeRange(5, 30);
        assertTrue(target.treeMap.isEmpty());
    }

    @Test
    public void testRangeRemoveRange6() throws Exception {
        target.addRange(10, 20);
        target.addRange(25, 30);
        target.removeRange(15, 27);
        assertEquals(2, target.treeMap.size());
        assertEquals(15, target.treeMap.get(10).intValue());
        assertEquals(30, target.treeMap.get(27).intValue());
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
