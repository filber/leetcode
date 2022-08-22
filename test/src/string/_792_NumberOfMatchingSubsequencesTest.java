package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _792_NumberOfMatchingSubsequencesTest {

    _792_NumberOfMatchingSubsequences target;

    @Before
    public void before() throws Exception {
        target = new _792_NumberOfMatchingSubsequences();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumMatchingSubseq1() throws Exception {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        int count = target.numMatchingSubseq(s, words);
        assertEquals(3, count);
    }

    @Test
    public void testNumMatchingSubseq2() throws Exception {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        int count = target.numMatchingSubseq(s, words);
        assertEquals(2, count);
    }
}
