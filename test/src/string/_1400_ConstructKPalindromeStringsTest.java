package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1400_ConstructKPalindromeStringsTest {

    _1400_ConstructKPalindromeStrings target = null;

    @Before
    public void before() throws Exception {
        target = new _1400_ConstructKPalindromeStrings();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCanConstruct1() throws Exception {
        // [a:2,b:1,e:2,l:2,n:2]
        boolean can = target.canConstruct("annabelle", 2);
        assertTrue(can);
    }

    @Test
    public void testCanConstruct2() throws Exception {
        boolean can = target.canConstruct("leetcode", 3);
        assertFalse(can);
    }

    @Test
    public void testCanConstruct3() throws Exception {
        boolean can = target.canConstruct("true", 4);
        assertTrue(can);
    }

    @Test
    public void testCanConstruct4() throws Exception {
        // y:8
        // z:7
        boolean can = target.canConstruct("yzyzyzyzyzyzyzy", 2);
        assertTrue(can);
    }

    @Test
    public void testCanConstruct5() throws Exception {
        boolean can = target.canConstruct("cr", 7);
        assertFalse(can);
    }
}
