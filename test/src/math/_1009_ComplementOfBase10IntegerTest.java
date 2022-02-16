package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1009_ComplementOfBase10IntegerTest {

    _1009_ComplementOfBase10Integer target = null;

    @Before
    public void before() throws Exception {
        target = new _1009_ComplementOfBase10Integer();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testBitwiseComplement1() throws Exception {
        // 5[101] -> 2[010]
        int c = target.bitwiseComplement(5);
        assertEquals(2, c);
    }

    @Test
    public void testBitwiseComplement2() throws Exception {
        // 7[111] -> 0[000]
        int c = target.bitwiseComplement(7);
        assertEquals(0, c);
    }

    @Test
    public void testBitwiseComplement3() throws Exception {
        // 10[1010] -> 5[0101]
        int c = target.bitwiseComplement(10);
        assertEquals(5, c);
    }

    @Test
    public void testBitwiseComplement4() throws Exception {
        // 1[1] -> 0[0]
        int c = target.bitwiseComplement(1);
        assertEquals(0, c);
    }

    @Test
    public void testBitwiseComplement5() throws Exception {
        // 0[0] -> 1[1]
        int c = target.bitwiseComplement(0);
        assertEquals(1, c);
    }
}
