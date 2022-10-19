package tp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _611_ValidTriangleNumberTest {

    _611_ValidTriangleNumber target = null;

    @Before
    public void before() throws Exception {
        target = new _611_ValidTriangleNumber();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testTriangleNumber1() throws Exception {
        int[] nums = {2, 2, 3, 4};
        int count = target.triangleNumber(nums);
        assertEquals(3, count);
    }

    @Test
    public void testTriangleNumber2() throws Exception {
        int[] nums = {4, 2, 3, 4};
        int count = target.triangleNumber(nums);
        assertEquals(4, count);
    }
}
