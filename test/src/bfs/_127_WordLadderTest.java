package bfs;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;

public class _127_WordLadderTest {

    _127_WordLadder ladder = null;
    @Before
    public void before() throws Exception {
        ladder = new _127_WordLadder();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testZeroLen() throws Exception {
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log");
        int len = ladder.ladderLength("hit", "cog", list);
        Assert.assertEquals(0, len);
    }

    @Test
    public void testTwoLen() throws Exception {
        List<String> list = Arrays.asList("cog");
        int len = ladder.ladderLength("cot", "cog", list);
        Assert.assertEquals(2, len);
    }

    @Test
    public void testTwoLenInList() throws Exception {
        List<String> list = Arrays.asList("cot", "cog");
        int len = ladder.ladderLength("cot", "cog", list);
        Assert.assertEquals(2, len);
    }

    @Test
    public void testFiveLen() throws Exception {
        List<String> list = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int len = ladder.ladderLength("hit", "cog", list);
        Assert.assertEquals(5,len);
    }


    @Test
    public void testLadderLength3() throws Exception {
        List<String> list = Arrays.asList("hot", "dog");
        int len = ladder.ladderLength("hot", "dog", list);
        Assert.assertEquals(0, len);
    }
}
