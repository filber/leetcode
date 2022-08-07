package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1220_CountVowelsPermutationTest {

    _1220_CountVowelsPermutation target = null;

    @Before
    public void before() throws Exception {
        target = new _1220_CountVowelsPermutation();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCountVowelPermutation1() throws Exception {
        int count = target.countVowelPermutation(1);
        assertEquals(5, count);
    }

    @Test
    public void testCountVowelPermutation2() throws Exception {
        int count = target.countVowelPermutation(2);
        assertEquals(10, count);
    }

    @Test
    public void testCountVowelPermutation3() throws Exception {
        int count = target.countVowelPermutation(5);
        assertEquals(68, count);
    }
}
