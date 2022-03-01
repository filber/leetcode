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
        target = new RangeModule();
    }

    @After
    public void after() throws Exception {
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
