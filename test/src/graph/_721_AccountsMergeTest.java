package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _721_AccountsMergeTest {

    _721_AccountsMerge target = null;

    @Before
    public void before() throws Exception {
        target = new _721_AccountsMerge();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testAccountsMerge1() throws Exception {
        List<String> john1 = List.of("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> john2 = List.of("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> mary = List.of("Mary", "mary@mail.com");
        List<String> john3 = List.of("John", "johnnybravo@mail.com");
        List<List<String>> accounts = List.of(john1, john2, mary, john3);
        List<List<String>> merged = target.accountsMerge(accounts);
        assertEquals(3, merged.size());
        assertArrayEquals(new String[]{"John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com"}, merged.get(0).toArray(new String[0]));
        assertArrayEquals(new String[]{"Mary", "mary@mail.com"}, merged.get(1).toArray(new String[0]));
        assertArrayEquals(new String[]{"John", "johnnybravo@mail.com"}, merged.get(2).toArray(new String[0]));
    }

    @Test
    public void testAccountsMerge2() throws Exception {
        List<String> d1 = List.of("David", "David0@m.co", "David1@m.co");
        List<String> d2 = List.of("David", "David3@m.co", "David4@m.co");
        List<String> d3 = List.of("David", "David4@m.co", "David5@m.co");
        List<String> d4 = List.of("David", "David2@m.co", "David3@m.co");
        List<String> d5 = List.of("David", "David1@m.co", "David2@m.co");
        List<List<String>> accounts = List.of(d1, d2, d3, d4, d5);
        List<List<String>> merged = target.accountsMerge(accounts);
        assertEquals(1, merged.size());
    }
}
