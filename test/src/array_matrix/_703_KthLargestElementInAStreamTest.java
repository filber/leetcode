package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import array_matrix._703_KthLargestElementInAStream.KthLargest;

import static org.junit.Assert.*;

public class _703_KthLargestElementInAStreamTest {

    _703_KthLargestElementInAStream target = null;

    @Before
    public void before() throws Exception {
        target = new _703_KthLargestElementInAStream();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testAdd1() throws Exception {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2}); // 8,5,4,2
        assertEquals(4, kthLargest.add(3)); // 8,5,[4],3,2
        assertEquals(5, kthLargest.add(5)); // 8,5,[5],4,3,2
        assertEquals(5, kthLargest.add(10)); // 10,8,[5],5,4,3,2
        assertEquals(8, kthLargest.add(9)); // 10,9,[8],5,5,4,3,2
        assertEquals(8, kthLargest.add(4)); // 10,9,[8],5,5,4,4,3,2
    }

    @Test
    public void testAdd2() throws Exception {
        KthLargest kthLargest = new KthLargest(1, new int[]{}); // []
        assertEquals(3, kthLargest.add(3)); // [3]
        assertEquals(3, kthLargest.add(2)); // [3],2
        assertEquals(4, kthLargest.add(4)); // [4],3,2
    }
}
