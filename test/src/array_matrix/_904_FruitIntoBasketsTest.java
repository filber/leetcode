package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _904_FruitIntoBasketsTest {

    _904_FruitIntoBaskets target = null;

    @Before
    public void before() throws Exception {
        target = new _904_FruitIntoBaskets();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testTotalFruit1() throws Exception {
        // [1,2,1]
        int fruits = target.totalFruit(new int[]{1, 2, 1});
        assertEquals(3, fruits);
    }

    @Test
    public void testTotalFruit2() throws Exception {
        // [1,2,2]
        int fruits = target.totalFruit(new int[]{0, 1, 2, 2});
        assertEquals(3, fruits);
    }

    @Test
    public void testTotalFruit3() throws Exception {
        // [2,3,2,2]
        int fruits = target.totalFruit(new int[]{1, 2, 3, 2, 2});
        assertEquals(4, fruits);
    }

    @Test
    public void testTotalFruit4() throws Exception {
        //[1,2] or [2,3]
        int fruits = target.totalFruit(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3});
        assertEquals(2, fruits);
    }

    @Test
    public void testTotalFruit5() throws Exception {
        // [1, 2, 1, 1, 2]
        int fruits = target.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4});
        assertEquals(5, fruits);
    }
}
