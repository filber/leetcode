package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _120_TriangleTest {

    _120_Triangle target = null;

    @Before
    public void before() throws Exception {
        target = new _120_Triangle();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMinimumTotal1() throws Exception {
        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        int sum = target.minimumTotal(triangle);
        assertEquals(11, sum);
    }

    @Test
    public void testMinimumTotal2() throws Exception {
        List<List<Integer>> triangle = List.of(
                List.of(-10)
        );
        int sum = target.minimumTotal(triangle);
        assertEquals(-10, sum);
    }
}
