package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import array_matrix._352_DataStreamAsDisjointIntervals.SummaryRanges;

import static org.junit.Assert.*;

public class _352_DataStreamAsDisjointIntervalsTest {

    SummaryRanges target = null;

    @Before
    public void before() throws Exception {
        target = new SummaryRanges();
    }

    @After
    public void after() throws Exception {

    }

    @Test
    public void testSummaryRanges1() throws Exception {
        target.addNum(1);
        assertArrayEquals(new int[][]{{1, 1}}, target.getIntervals());

        target.addNum(3);
        assertArrayEquals(new int[][]{{1, 1}, {3, 3}}, target.getIntervals());

        target.addNum(7);
        assertArrayEquals(new int[][]{{1, 1}, {3, 3}, {7, 7}}, target.getIntervals());

        target.addNum(2);
        assertArrayEquals(new int[][]{{1, 3}, {7, 7}}, target.getIntervals());

        target.addNum(6);
        assertArrayEquals(new int[][]{{1, 3}, {6, 7}}, target.getIntervals());
    }

} 
