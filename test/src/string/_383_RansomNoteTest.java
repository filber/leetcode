package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _383_RansomNoteTest {

    _383_RansomNote target;

    @Before
    public void before() throws Exception {
        target = new _383_RansomNote();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCanConstruct1() throws Exception {
        boolean can = target.canConstruct("a", "b");
        assertFalse(can);
    }

    @Test
    public void testCanConstruct2() throws Exception {
        boolean can = target.canConstruct("aa", "ab");
        assertFalse(can);
    }

    @Test
    public void testCanConstruct3() throws Exception {
        boolean can = target.canConstruct("aa", "aab");
        assertTrue(can);
    }
}
