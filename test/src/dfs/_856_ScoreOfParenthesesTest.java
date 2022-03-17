package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _856_ScoreOfParenthesesTest {

    _856_ScoreOfParentheses target = null;

    @Before
    public void before() throws Exception {
        target = new _856_ScoreOfParentheses();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testScoreOfParentheses1() throws Exception {
        int score = target.scoreOfParentheses("()");
        assertEquals(1, score);
    }

    @Test
    public void testScoreOfParentheses2() throws Exception {
        int score = target.scoreOfParentheses("()()");
        assertEquals(2, score);
    }

    @Test
    public void testScoreOfParentheses3() throws Exception {
        int score = target.scoreOfParentheses("(()())");
        assertEquals(4, score);
    }

    @Test
    public void testScoreOfParentheses4() throws Exception {
        int score = target.scoreOfParentheses("()(())");
        assertEquals(3, score);
    }

    @Test
    public void testScoreOfParentheses5() throws Exception {
        int score = target.scoreOfParentheses("()((()))");
        assertEquals(5, score);
    }

} 
