package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _763_PartitionLabelsTest {

    _763_PartitionLabels target = null;

    @Before
    public void before() throws Exception {
        target = new _763_PartitionLabels();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testPartitionLabels1() throws Exception {
        List<Integer> parts = target.partitionLabels("ababcbacadefegdehijhklij");
        assertArrayEquals(new Integer[]{9, 7, 8}, parts.toArray(new Integer[0]));
    }

    @Test
    public void testPartitionLabels2() throws Exception {
        List<Integer> parts = target.partitionLabels("eccbbbbdec");
        assertArrayEquals(new Integer[]{10}, parts.toArray(new Integer[0]));
    }

    @Test
    public void testPartitionLabels3() throws Exception {
        List<Integer> parts = target.partitionLabels("abcd");
        assertArrayEquals(new Integer[]{1, 1, 1, 1}, parts.toArray(new Integer[0]));
    }

    @Test
    public void testPartitionLabels4() throws Exception {
        List<Integer> parts = target.partitionLabels("abcda");
        assertArrayEquals(new Integer[]{5}, parts.toArray(new Integer[0]));
    }
}
