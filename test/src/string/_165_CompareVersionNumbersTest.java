package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _165_CompareVersionNumbersTest {

    _165_CompareVersionNumbers target = null;

    @Before
    public void before() throws Exception {
        target = new _165_CompareVersionNumbers();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCompareVersion1() throws Exception {
        int rst = target.compareVersion("1.1", "1.0");
        assertEquals(1, rst);
    }

    @Test
    public void testCompareVersion2() throws Exception {
        int rst = target.compareVersion("1.01", "1.001");
        assertEquals(0, rst);
    }

    @Test
    public void testCompareVersion3() throws Exception {
        int rst = target.compareVersion("1.0", "1.0.0");
        assertEquals(0, rst);
    }

    @Test
    public void testCompareVersion4() throws Exception {
        int rst = target.compareVersion("0.1", "1.1");
        assertEquals(-1, rst);
    }

    @Test
    public void testCompareVersion5() throws Exception {
        int rst = target.compareVersion("1.0", "1.0.1");
        assertEquals(-1, rst);
    }

    @Test
    public void testCompareVersion6() throws Exception {
        int rst = target.compareVersion("1.0.1", "1.0");
        assertEquals(1, rst);
    }

    @Test
    public void testCompareVersion7() throws Exception {
        int rst = target.compareVersion("1.05", "1.1");
        assertEquals(1, rst);
    }

    @Test
    public void testCompareVersion8() throws Exception {
        int rst = target.compareVersion("1.1", "1.10");
        assertEquals(-1, rst);
    }

    @Test
    public void testCompareVersion9() throws Exception {
        int rst = target.compareVersion("1.2", "1.10");
        assertEquals(-1, rst);
    }
}
