package pq;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import pq._295_FindMedianFromDataStream.MedianFinder;

import static org.junit.Assert.*;

public class _295_FindMedianFromDataStreamTest {

    _295_FindMedianFromDataStream target = null;

    @Before
    public void before() throws Exception {
        target = new _295_FindMedianFromDataStream();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMedianFinder1() throws Exception {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        double m1 = medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        assertEquals(1.5, m1, 0.0005);
        medianFinder.addNum(3);    // arr[1, 2, 3]
        double m2 = medianFinder.findMedian(); // return 2.0
        assertEquals(2.0, m2, 0.0005);
    }
}
