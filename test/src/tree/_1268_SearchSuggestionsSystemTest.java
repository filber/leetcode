package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _1268_SearchSuggestionsSystemTest {

    _1268_SearchSuggestionsSystem target;

    @Before
    public void before() throws Exception {
        target = new _1268_SearchSuggestionsSystem();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testSuggestedProducts1() throws Exception {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        List<List<String>> list = target.suggestedProducts(products, searchWord);
        assertEquals(searchWord.length(), list.size());
        assertArrayEquals(new String[]{"mobile", "moneypot", "monitor"}, list.get(0).toArray(new String[0]));
        assertArrayEquals(new String[]{"mobile", "moneypot", "monitor"}, list.get(1).toArray(new String[0]));
        assertArrayEquals(new String[]{"mouse", "mousepad"}, list.get(2).toArray(new String[0]));
        assertArrayEquals(new String[]{"mouse", "mousepad"}, list.get(3).toArray(new String[0]));
        assertArrayEquals(new String[]{"mouse", "mousepad"}, list.get(4).toArray(new String[0]));
    }

    @Test
    public void testSuggestedProducts2() throws Exception {
        String[] products = {"havana"};
        String searchWord = "havana";
        List<List<String>> list = target.suggestedProducts(products, searchWord);
        assertEquals(searchWord.length(), list.size());
        assertArrayEquals(new String[]{"havana"}, list.get(0).toArray(new String[0]));
        assertArrayEquals(new String[]{"havana"}, list.get(1).toArray(new String[0]));
        assertArrayEquals(new String[]{"havana"}, list.get(2).toArray(new String[0]));
        assertArrayEquals(new String[]{"havana"}, list.get(3).toArray(new String[0]));
        assertArrayEquals(new String[]{"havana"}, list.get(4).toArray(new String[0]));
    }

    @Test
    public void testSuggestedProducts3() throws Exception {
        String[] products = {"bags", "baggage", "banner", "box", "cloths"};
        String searchWord = "bags";
        List<List<String>> list = target.suggestedProducts(products, searchWord);
        assertEquals(searchWord.length(), list.size());
        assertArrayEquals(new String[]{"baggage", "bags", "banner"}, list.get(0).toArray(new String[0]));
        assertArrayEquals(new String[]{"baggage", "bags", "banner"}, list.get(1).toArray(new String[0]));
        assertArrayEquals(new String[]{"baggage", "bags"}, list.get(2).toArray(new String[0]));
        assertArrayEquals(new String[]{"bags"}, list.get(3).toArray(new String[0]));
    }
}
