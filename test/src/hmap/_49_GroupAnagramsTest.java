package hmap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _49_GroupAnagramsTest {

    _49_GroupAnagrams target = null;

    @Before
    public void before() throws Exception {
        target = new _49_GroupAnagrams();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testGroupAnagrams1() throws Exception {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = target.groupAnagrams(strs);
        assertEquals(3, list.size());
        assertArrayEquals(new String[]{"bat"}, list.get(0).toArray(new String[0]));
        assertArrayEquals(new String[]{"tan", "nat"}, list.get(1).toArray(new String[0]));
        assertArrayEquals(new String[]{"eat", "tea", "ate"}, list.get(2).toArray(new String[0]));
    }
}
