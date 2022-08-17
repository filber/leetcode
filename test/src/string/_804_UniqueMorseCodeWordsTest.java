package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _804_UniqueMorseCodeWordsTest {

    _804_UniqueMorseCodeWords target = null;

    @Before
    public void before() throws Exception {
        target = new _804_UniqueMorseCodeWords();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testUniqueMorseRepresentations1() throws Exception {
        int unique = target.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
        assertEquals(2, unique);
    }

    @Test
    public void testUniqueMorseRepresentations2() throws Exception {
        int unique = target.uniqueMorseRepresentations(new String[]{"a"});
        assertEquals(1, unique);
    }
}
