package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import stack._225_ImplementStackUsingQueues.MyStack;

public class _225_ImplementStackUsingQueuesTest {

    MyStack target = null;

    @Before
    public void before() throws Exception {
        target = new MyStack();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testStack1() throws Exception {
        target.push(1);
        target.push(2);

        assertEquals(2, target.top());
        assertEquals(2, target.pop());
        assertFalse(target.empty());
        assertEquals(1, target.top());
        assertEquals(1, target.pop());
        assertTrue(target.empty());
    }
}
