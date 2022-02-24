package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2014_LongestSubsequenceRepeatedKTimesTest {

    _2014_LongestSubsequenceRepeatedKTimes target = null;

    @Before
    public void before() throws Exception {
        target = new _2014_LongestSubsequenceRepeatedKTimes();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testLongestSubsequenceRepeatedK1() throws Exception {
        // let > ete
        String subsequence = target.longestSubsequenceRepeatedK("letsleetcode", 2);
        assertEquals("let", subsequence);
    }

    @Test
    public void testLongestSubsequenceRepeatedK2() throws Exception {
        String subsequence = target.longestSubsequenceRepeatedK("bb", 2);
        assertEquals("b", subsequence);
    }

    @Test
    public void testLongestSubsequenceRepeatedK3() throws Exception {
        String subsequence = target.longestSubsequenceRepeatedK("ab", 2);
        assertEquals("", subsequence);
    }

    @Test
    public void testLongestSubsequenceRepeatedK4() throws Exception {
        String subsequence = target.longestSubsequenceRepeatedK("vptwvlvcmptwvlvptwvlvptrwvlvptwvlvptwrvlvptwvlvpktwivlvptwovlcpvptwvlvptwvlvptwvlvputwvlvfptwvlvptwkvlvptwvlvptwvlvhptwavlqvptswvlwvptwvlvptwvlvpotowvl",
                22);
        assertEquals("vptwvl", subsequence);
    }

    @Test
    public void testLongestSubsequenceRepeatedK5() throws Exception {
        String subsequence = target.longestSubsequenceRepeatedK("ophxajilohxaihyldohxailohfxailodhxailohxailohxailoihxaqrilohxailohxailqohxailohxaillohxailohxzrailohxavilohxailohxailwohxailohxailohaxailaohxailohxbailohxailohxailodhxailodlhxailohxoailohxaziglohxailohxailohxaqilohxeaihxlohxailohxiailohlxailohxhailohxsaiolohxailolwhxkailohxgamilohoxailowhxailmohxaijlohxailohxailohxailohxaijlohxuaeizlohxailohxsaipylcmohyxailohxagilohxailoyhxailohxailohxbaigelohxailohixaiklohxaiilohxailohxailohxalilohxvsamilohxailohxgaillohxailohxaxilohxaoilohxailohxyailohxaillohxailohxailohxailohxrxailqohxailohxailohxailohxaadilohxailsohxagilohuxgailoehxahilohxailojhmoxailohxascilomhxailohxadilohxnailchohxaitlohxailohhxailohxailohxailohxaiilohxailohxailohxpailohxailonhyxawilohbxailuohcsxailokhxacilohxailohxayilohxailohxailohxailohxauilohxailohxtaigllohxailohxakilohxailohxaiplohxailtoahxaaiflohxhvailohxaqiluohhxailohxailohxawilohxxailohxlailohxailohxailohoxail",
                127);
        assertEquals("ohxail", subsequence);
    }
}
