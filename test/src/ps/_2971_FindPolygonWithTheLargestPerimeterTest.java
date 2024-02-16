package ps;

import org.junit.Before;
import org.junit.Test;
import ps._2971_FindPolygonWithTheLargestPerimeter;

import static org.junit.Assert.*;

public class _2971_FindPolygonWithTheLargestPerimeterTest {

    _2971_FindPolygonWithTheLargestPerimeter target;

    @Before
    public void setUp() throws Exception {
        target = new _2971_FindPolygonWithTheLargestPerimeter();
    }

    @Test
    public void testLargestPerimeter1() {
        int[] nums = {1, 5, 1, 6};
        long perimeter = target.largestPerimeter(nums);
        // <1,1,5,6>
        assertEquals(13, perimeter);
    }

    @Test
    public void testLargestPerimeter2() {
        int[] nums = {5, 5, 5};
        long perimeter = target.largestPerimeter(nums);
        assertEquals(15, perimeter);
    }

    @Test
    public void testLargestPerimeter3() {
        int[] nums = {1, 12, 1, 2, 5, 50, 3};
        long perimeter = target.largestPerimeter(nums);
        assertEquals(12, perimeter);
    }

    @Test
    public void testLargestPerimeter4() {
        int[] nums = {5, 5, 50};
        long perimeter = target.largestPerimeter(nums);
        assertEquals(-1, perimeter);
    }
}