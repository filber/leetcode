package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _946_ValidateStackSequencesTest {

    _946_ValidateStackSequences target = null;

    @Before
    public void before() throws Exception {
        target = new _946_ValidateStackSequences();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testValidateStackSequences1() throws Exception {
        boolean res = target.validateStackSequences(
                new int[]{1, 2, 3, 4, 5},
                new int[]{4, 5, 3, 2, 1});
        assertTrue(res);
    }

    @Test
    public void testValidateStackSequences2() throws Exception {
        boolean res = target.validateStackSequences(
                new int[]{1, 2, 3, 4, 5},
                new int[]{4, 3, 5, 1, 2});
        assertFalse(res);
    }

    @Test
    public void testValidateStackSequences3() throws Exception {
        boolean res = target.validateStackSequences(
                new int[]{1, 2},
                new int[]{2, 1});
        assertTrue(res);
    }

    @Test
    public void testValidateStackSequences4() throws Exception {
        boolean res = target.validateStackSequences(
                new int[]{1, 2},
                new int[]{1, 2});
        assertTrue(res);
    }

    @Test
    public void testValidateStackSequences5() throws Exception {
        boolean res = target.validateStackSequences(
                new int[]{1, 2, 3},
                new int[]{3, 1, 2});
        assertFalse(res);
    }

    @Test
    public void testValidateStackSequences6() throws Exception {
        boolean res = target.validateStackSequences(
                new int[]{2, 1, 0},
                new int[]{1, 2, 0});
        assertTrue(res);
    }
}
