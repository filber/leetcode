package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _17_LetterCombinationsOfAPhoneNumberTest {

    _17_LetterCombinationsOfAPhoneNumber target = null;

    @Before
    public void before() throws Exception {
        target = new _17_LetterCombinationsOfAPhoneNumber();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testLetterCombinations1() throws Exception {
        List<String> ans = target.letterCombinations("");
        assertTrue(ans.isEmpty());
    }

    @Test
    public void testLetterCombinations2() throws Exception {
        List<String> ans = target.letterCombinations("2");
        assertArrayEquals(new String[]{"a", "b", "c"}, ans.toArray(new String[0]));
    }

    @Test
    public void testLetterCombinations3() throws Exception {
        List<String> ans = target.letterCombinations("23");
        assertArrayEquals(new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"}, ans.toArray(new String[0]));
    }
}
