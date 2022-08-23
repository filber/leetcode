package sw;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1461_CheckIfAStringContainsAllBinaryCodesOfSizeKTest {

    _1461_CheckIfAStringContainsAllBinaryCodesOfSizeK target = null;

    @Before
    public void before() throws Exception {
        target = new _1461_CheckIfAStringContainsAllBinaryCodesOfSizeK();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testHasAllCodes1() throws Exception {
        boolean has = target.hasAllCodes("00110110", 2);
        assertTrue(has);
    }

    @Test
    public void testHasAllCodes2() throws Exception {
        boolean has = target.hasAllCodes("0110", 1);
        assertTrue(has);
    }

    @Test
    public void testHasAllCodes3() throws Exception {
        boolean has = target.hasAllCodes("0110", 2);
        assertFalse(has);
    }
}
