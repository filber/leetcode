package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _13_RomanToIntegerTest {

    _13_RomanToInteger target = null;

    @Before
    public void before() throws Exception {
        target = new _13_RomanToInteger();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRomanToInt1() throws Exception {
        int val = target.romanToInt("III");
        assertEquals(3, val);
    }

    @Test
    public void testRomanToInt2() throws Exception {
        int val = target.romanToInt("LVIII");
        assertEquals(58, val);
    }

    @Test
    public void testRomanToInt3() throws Exception {
        int val = target.romanToInt("MCMXCIV");
        assertEquals(1994, val);
    }
} 
