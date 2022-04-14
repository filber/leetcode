package bs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import bs._702_SearchInASortedArrayOfUnknownSize.ArrayReader;

import static org.junit.Assert.*;

public class _702_SearchInASortedArrayOfUnknownSizeTest {

    _702_SearchInASortedArrayOfUnknownSize target = null;

    @Before
    public void before() throws Exception {
        target = new _702_SearchInASortedArrayOfUnknownSize();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSearch1() throws Exception {
        ArrayReader ar = new ArrayReader(new int[]{-1, 0, 3, 5, 9, 12});
        int idx = target.searchUnknownSize(ar, 9);
        assertEquals(4, idx);
    }

    @Test
    public void testSearch2() throws Exception {
        ArrayReader ar = new ArrayReader(new int[]{-1, 0, 3, 5, 9, 12});
        int idx = target.searchUnknownSize(ar, 2);
        assertEquals(-1, idx);
    }

    @Test
    public void testSearch3() throws Exception {
        ArrayReader ar = new ArrayReader(new int[]{1});
        int idx = target.searchUnknownSize(ar, 1);
        assertEquals(0, idx);
    }

    @Test
    public void testSearch4() throws Exception {
        ArrayReader ar = new ArrayReader(new int[]{1});
        int idx = target.searchUnknownSize(ar, 2);
        assertEquals(-1, idx);
    }
}
