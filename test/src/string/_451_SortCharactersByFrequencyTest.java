package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _451_SortCharactersByFrequencyTest {

    _451_SortCharactersByFrequency target = null;

    @Before
    public void before() throws Exception {
        target = new _451_SortCharactersByFrequency();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFrequencySort1() throws Exception {
        String str = target.frequencySort("tree");
        assertEquals("eert", str);
    }

    @Test
    public void testFrequencySort2() throws Exception {
        String str = target.frequencySort("Aabb");
        assertEquals("bbAa", str);
    }

    @Test
    public void testFrequencySort3() throws Exception {
        String str = target.frequencySort("cccaaa");
        assertEquals("aaaccc", str);
    }
}
