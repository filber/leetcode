package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class _320_GeneralizedAbbreviationTest {

    _320_GeneralizedAbbreviation target = null;

    @Before
    public void before() throws Exception {
        target = new _320_GeneralizedAbbreviation();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testGenerateAbbreviations0() throws Exception {
        List<String> list = target.generateAbbreviations("");
        assertEquals("", list.get(0));
    }

    @Test
    public void testGenerateAbbreviations1() throws Exception {
        List<String> list = target.generateAbbreviations("a");
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("a"));
        assertTrue(set.contains("1"));
    }

    @Test
    public void testGenerateAbbreviations2() throws Exception {
        List<String> list = target.generateAbbreviations("ab");
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("ab"));
        assertTrue(set.contains("1b"));
        assertTrue(set.contains("a1"));
        assertTrue(set.contains("2"));
    }

    @Test
    public void testGenerateAbbreviations3() throws Exception {
        List<String> list = target.generateAbbreviations("abc");
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("abc"));
        assertTrue(set.contains("1bc"));
        assertTrue(set.contains("a1c"));
        assertTrue(set.contains("ab1"));
        assertTrue(set.contains("a2"));
        assertTrue(set.contains("2c"));
        assertTrue(set.contains("1b1"));
        assertTrue(set.contains("3"));
    }

    @Test
    public void testGenerateAbbreviations4() throws Exception {
        List<String> list = target.generateAbbreviations("word");
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("word"));
        assertTrue(set.contains("1ord"));
        assertTrue(set.contains("w1rd"));
        assertTrue(set.contains("wo1d"));
        assertTrue(set.contains("wor1"));
        assertTrue(set.contains("2rd"));
        assertTrue(set.contains("w2d"));
        assertTrue(set.contains("wo2"));
        assertTrue(set.contains("1o1d"));
        assertTrue(set.contains("1or1"));
        assertTrue(set.contains("w1r1"));
        assertTrue(set.contains("1o2"));
        assertTrue(set.contains("2r1"));
        assertTrue(set.contains("3d"));
        assertTrue(set.contains("w3"));
        assertTrue(set.contains("4"));
    }

} 
