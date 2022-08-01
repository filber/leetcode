package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _916_WordSubsetsTest {

    _916_WordSubsets target;

    @Before
    public void before() throws Exception {
        target = new _916_WordSubsets();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testWordSubsets1() throws Exception {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};
        List<String> list = target.wordSubsets(words1, words2);
        assertArrayEquals(new String[]{"facebook", "google", "leetcode"}, list.toArray(new String[0]));
    }

    @Test
    public void testWordSubsets2() throws Exception {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"l", "e"};
        List<String> list = target.wordSubsets(words1, words2);
        assertArrayEquals(new String[]{"apple", "google", "leetcode"}, list.toArray(new String[0]));
    }
} 
