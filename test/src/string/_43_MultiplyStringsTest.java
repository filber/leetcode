package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _43_MultiplyStringsTest {

    _43_MultiplyStrings target = null;

    @Before
    public void before() throws Exception {
        target = new _43_MultiplyStrings();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMultiply1() throws Exception {
        String result = target.multiply("2", "3");
        assertEquals("6", result);
    }

    @Test
    public void testMultiply2() throws Exception {
        String result = target.multiply("123", "456");
        assertEquals("56088", result);
    }

    @Test
    public void testMultiply3() throws Exception {
        String result = target.multiply("0", "456");
        assertEquals("0", result);
    }

    @Test
    public void testMultiply4() throws Exception {
        String result = target.multiply("456", "0");
        assertEquals("0", result);
    }

    @Test
    public void testMultiply7() throws Exception {
        String result = target.multiply("999", "99");
        assertEquals("98901", result);
    }

    @Test
    public void testMultiply5() throws Exception {
        String result = target.multiply("123456789", "876543");
        assertEquals("108215184200427", result);
    }

    @Test
    public void testMultiply6() throws Exception {
        String result = target.multiply("876543", "123456789");
        assertEquals("108215184200427", result);
    }

    @Test
    public void testMultiply8() throws Exception {
        String result = target.multiply("9", "9");
        assertEquals("81", result);
    }

    @Test
    public void testMultiply9() throws Exception {
        String result = target.multiply("870000", "123456789");
        assertEquals("107407406430000", result);
    }
}
