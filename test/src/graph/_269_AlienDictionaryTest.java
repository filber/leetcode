package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _269_AlienDictionaryTest {

    _269_AlienDictionary target = null;

    @Before
    public void before() throws Exception {
        target = new _269_AlienDictionary();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testAlienOrder1() throws Exception {
        String order = target.alienOrder(new String[]{
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        });
        assertEquals("wertf", order);
    }

    @Test
    public void testAlienOrder2() throws Exception {
        String order = target.alienOrder(new String[]{
                "z",
                "x"
        });
        assertEquals("zx", order);
    }

    @Test
    public void testAlienOrder3() throws Exception {
        String order = target.alienOrder(new String[]{
        });
        assertEquals("", order);
    }

    @Test
    public void testAlienOrder4() throws Exception {
        String order = target.alienOrder(new String[]{
                "zx"
        });
        assertEquals("", order);
    }

    @Test
    public void testAlienOrder5() throws Exception {
        String order = target.alienOrder(new String[]{
                "wr",
                "rr",
                "rw"
        });
        assertEquals("", order);
    }

    @Test
    public void testAlienOrder6() throws Exception {
        String order = target.alienOrder(new String[]{
                "a",
                "wr",
                "rr",
                "rw"
        });
        assertEquals("", order);
    }
}
