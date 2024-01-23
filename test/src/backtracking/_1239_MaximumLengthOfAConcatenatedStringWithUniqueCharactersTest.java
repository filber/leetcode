package backtracking;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class _1239_MaximumLengthOfAConcatenatedStringWithUniqueCharactersTest {

    _1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters target;

    @Before
    public void setUp() throws Exception {
        target = new _1239_MaximumLengthOfAConcatenatedStringWithUniqueCharacters();
    }

    @Test
    public void testMaxLength1() {
        String[] strs = {"un", "iq", "ue"};
        List<String> arr = Arrays.asList(strs);
        int maxLen = target.maxLength(arr);
        assertEquals(4, maxLen);
    }

    @Test
    public void testMaxLength2() {
        String[] strs = {"cha", "r", "act", "ers"};
        List<String> arr = Arrays.asList(strs);
        int maxLen = target.maxLength(arr);
        assertEquals(6, maxLen);
    }

    @Test
    public void testMaxLength3() {
        String[] strs = {"abcdefghijklmnopqrstuvwxyz"};
        List<String> arr = Arrays.asList(strs);
        int maxLen = target.maxLength(arr);
        assertEquals(26, maxLen);
    }

    @Test
    public void testMaxLength4() {
        String[] strs = {"aa","bb"};
        List<String> arr = Arrays.asList(strs);
        int maxLen = target.maxLength(arr);
        assertEquals(0, maxLen);
    }
}