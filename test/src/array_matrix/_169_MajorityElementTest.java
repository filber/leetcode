package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _169_MajorityElementTest {

    _169_MajorityElement target = null;

    @Before
    public void before() throws Exception {
        target = new _169_MajorityElement();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMajorityElement1() throws Exception {
        int majority = target.majorityElement(new int[]{3, 2, 3});
        assertEquals(3, majority);
    }

    @Test
    public void testMajorityElement2() throws Exception {
        int majority = target.majorityElement(new int[]{3});
        assertEquals(3, majority);
    }

    @Test
    public void testMajorityElement3() throws Exception {
        int majority = target.majorityElement(new int[]{3, 2, 2});
        assertEquals(2, majority);
    }

    @Test
    public void testMajorityElement4() throws Exception {
        int majority = target.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        assertEquals(2, majority);
    }

    @Test
    public void testMajorityElement5() throws Exception {
        int majority = target.majorityElement(new int[]{2, 2, 2, 1, 1});
        assertEquals(2, majority);
    }
}
