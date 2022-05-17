package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _150_EvaluateReversePolishNotationTest {

    _150_EvaluateReversePolishNotation target = null;

    @Before
    public void before() throws Exception {
        target = new _150_EvaluateReversePolishNotation();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testEvalRPN1() throws Exception {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int rst = target.evalRPN(tokens);
        assertEquals(9, rst);
    }

    @Test
    public void testEvalRPN2() throws Exception {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int rst = target.evalRPN(tokens);
        assertEquals(22, rst);
    }

    @Test
    public void testEvalRPN3() throws Exception {
        String[] tokens = {"4", "13", "5", "/", "+"};
        int rst = target.evalRPN(tokens);
        assertEquals(6, rst);
    }
}
