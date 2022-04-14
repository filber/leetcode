package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _476_NumberComplementTest {

    _476_NumberComplement target = null;

    @Before
    public void before() throws Exception {
        target = new _476_NumberComplement();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindComplement1() throws Exception {
        int c = target.findComplement(1);
        assertEquals(0, c);
    }

    @Test
    public void testFindComplement2() throws Exception {
        int c = target.findComplement(2);
        assertEquals(1, c);
    }

    @Test
    public void testFindComplement3() throws Exception {
        int c = target.findComplement(3);
        assertEquals(0, c);
    }

    @Test
    public void testFindComplement4() throws Exception {
        int c = target.findComplement(4);
        assertEquals(3, c);
    }

    @Test
    public void testFindComplement5() throws Exception {
        int c = target.findComplement(5);
        assertEquals(2, c);
    }
}
