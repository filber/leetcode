package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _259_3SumSmallerTest {

    _259_3SumSmaller target = null;

    @Before
    public void before() throws Exception {
        target = new _259_3SumSmaller();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testThreeSumSmaller1() throws Exception {
        //[-2,0,1], [-2,0,3]
        int triplets = target.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2);
        assertEquals(2, triplets);
    }

    @Test
    public void testThreeSumSmaller2() throws Exception {
        //[-2,0,1], [-2,0,3], [-2,1,3]
        int triplets = target.threeSumSmaller(new int[]{-2, 0, 1, 3}, 3);
        assertEquals(3, triplets);
    }

    @Test
    public void testThreeSumSmaller3() throws Exception {
        //[-2,0,1]
        int triplets = target.threeSumSmaller(new int[]{-2, 0, 1, 3}, 1);
        assertEquals(1, triplets);
    }
}
