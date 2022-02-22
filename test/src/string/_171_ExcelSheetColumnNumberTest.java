package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _171_ExcelSheetColumnNumberTest {

    _171_ExcelSheetColumnNumber target = null;

    @Before
    public void before() throws Exception {
        target = new _171_ExcelSheetColumnNumber();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testTitleToNumber1() throws Exception {
        int val = target.titleToNumber("A");
        assertEquals(1, val);
    }

    @Test
    public void testTitleToNumber2() throws Exception {
        int val = target.titleToNumber("Z");
        assertEquals(26, val);
    }

    @Test
    public void testTitleToNumber3() throws Exception {
        int val = target.titleToNumber("AB");
        assertEquals(28, val);
    }

    @Test
    public void testTitleToNumber4() throws Exception {
        int val = target.titleToNumber("ZY");
        assertEquals(701, val);
    }
}
