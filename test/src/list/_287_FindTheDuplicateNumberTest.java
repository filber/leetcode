package list;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _287_FindTheDuplicateNumberTest {

    _287_FindTheDuplicateNumber target = null;

    @Before
    public void before() throws Exception {
        target = new _287_FindTheDuplicateNumber();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testFindDuplicate1() throws Exception {
        int num = target.findDuplicate(new int[]{1, 3, 4, 2, 2});
        assertEquals(2, num);
    }

    @Test
    public void testFindDuplicate2() throws Exception {
        int num = target.findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1});
        assertEquals(9, num);
    }

    @Test
    public void testFindDuplicate3() throws Exception {
        int num = target.findDuplicate(new int[]{3, 1, 3, 4, 2});
        assertEquals(3, num);
    }
}
