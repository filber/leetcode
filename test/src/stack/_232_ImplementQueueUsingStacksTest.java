package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import stack._232_ImplementQueueUsingStacks.MyQueue;

import static org.junit.Assert.*;

public class _232_ImplementQueueUsingStacksTest {

    MyQueue target = null;

    @Before
    public void before() throws Exception {
        target = new MyQueue();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testQueues1() throws Exception {
        target.push(1);  // queue is: [1]
        target.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        assertEquals(1, target.peek()); // return 1
        assertEquals(1, target.pop()); // return 1, queue is [2]
        assertFalse(target.empty()); // queue is [2]
        assertEquals(2, target.peek()); // return 2
        assertEquals(2, target.pop()); // return 2, queue is []
        assertTrue(target.empty()); // queue is []
    }
}
