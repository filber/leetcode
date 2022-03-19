package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _895_MaximumFrequencyStackTest {

    _895_MaximumFrequencyStack.FreqStack freqStack = null;

    @Before
    public void before() throws Exception {
        freqStack = new _895_MaximumFrequencyStack.FreqStack();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFreqStack1() throws Exception {
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        assertEquals(5, freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        assertEquals(7, freqStack.pop());   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        assertEquals(5, freqStack.pop());   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        assertEquals(4, freqStack.pop());   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }
} 
