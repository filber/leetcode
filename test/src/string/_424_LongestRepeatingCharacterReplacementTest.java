package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _424_LongestRepeatingCharacterReplacementTest {

    _424_LongestRepeatingCharacterReplacement target = null;

    @Before
    public void before() throws Exception {
        target = new _424_LongestRepeatingCharacterReplacement();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCharacterReplacement1() throws Exception {
        int len = target.characterReplacement("ABAB", 2);
        assertEquals(4, len);
    }

    @Test
    public void testCharacterReplacement6() throws Exception {
        int len = target.characterReplacement("ABABC", 2);
        assertEquals(4, len);
    }

    @Test
    public void testCharacterReplacement2() throws Exception {
        int len = target.characterReplacement("AABABBA", 1);
        assertEquals(4, len);
    }

    @Test
    public void testCharacterReplacement3() throws Exception {
        int len = target.characterReplacement("AABABBA", 0);
        assertEquals(2, len);
    }

    @Test
    public void testCharacterReplacement4() throws Exception {
        int len = target.characterReplacement("ABCDEFG", 0);
        assertEquals(1, len);
    }

    @Test
    public void testCharacterReplacement5() throws Exception {
        int len = target.characterReplacement("ABCDEFG", 1);
        assertEquals(2, len);
    }

    @Test
    public void testCharacterReplacement7() throws Exception {
        int len = target.characterReplacement("ABABCCCC", 2);
        assertEquals(6, len);
    }

    @Test
    public void testCharacterReplacement8() throws Exception {
        int len = target.characterReplacement("ABCCCC", 2);
        assertEquals(6, len);
    }

    @Test
    public void testCharacterReplacement9() throws Exception {
        int len = target.characterReplacement("A", 2);
        assertEquals(1, len);
    }
}
