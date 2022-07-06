package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _509_FibonacciNumberTest {

    _509_FibonacciNumber target = null;

    @Before
    public void before() throws Exception {
        target = new _509_FibonacciNumber();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFib1() throws Exception {
        int fib = target.fib(2);
        assertEquals(1, fib);
    }

    @Test
    public void testFib2() throws Exception {
        int fib = target.fib(3);
        assertEquals(2, fib);
    }

    @Test
    public void testFib3() throws Exception {
        int fib = target.fib(4);
        assertEquals(3, fib);
    }

    @Test
    public void testFib4() throws Exception {
        int fib = target.fib(30);
        assertEquals(3, fib);
    }
}
