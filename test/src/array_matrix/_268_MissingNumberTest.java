package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _268_MissingNumberTest {

    _268_MissingNumber target = null;

    @Before
    public void before() throws Exception {
        target = new _268_MissingNumber();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMissingNumber1() throws Exception {
        int num = target.missingNumber(new int[]{3, 0, 1});
        assertEquals(2, num);
    }

    @Test
    public void testMissingNumber2() throws Exception {
        int num = target.missingNumber(new int[]{0, 1});
        assertEquals(2, num);
    }

    @Test
    public void testMissingNumber3() throws Exception {
        int num = target.missingNumber(new int[]{4, 0, 5, 1, 2});
        assertEquals(3, num);
    }

    @Test
    public void testMissingNumber4() throws Exception {
        int num = target.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
        assertEquals(8, num);
    }

    @Test
    public void testMissingNumber5() throws Exception {
        int num = target.missingNumber(new int[]{3, 2, 1});
        assertEquals(0, num);
    }
}
