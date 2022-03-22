package greedy;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1663_SmallestStringWithAGivenNumericValueTest {

    _1663_SmallestStringWithAGivenNumericValue target = null;

    @Before
    public void before() throws Exception {
        target = new _1663_SmallestStringWithAGivenNumericValue();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testGetSmallestString1() throws Exception {
        String str = target.getSmallestString(3, 27);
        assertEquals("aay", str);
    }

    @Test
    public void testGetSmallestString2() throws Exception {
        String str = target.getSmallestString(1, 25);
        assertEquals("y", str);
    }

    @Test
    public void testGetSmallestString3() throws Exception {
        String str = target.getSmallestString(5, 73);
        assertEquals("aaszz", str);
    }

    @Test
    public void testGetSmallestString4() throws Exception {
        String str = target.getSmallestString(2, 3);
        assertEquals("ab", str);
    }
}
