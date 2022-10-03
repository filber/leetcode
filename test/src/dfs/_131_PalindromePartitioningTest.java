package dfs;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _131_PalindromePartitioningTest {

    _131_PalindromePartitioning target;

    @Before
    public void before() throws Exception {
        target = new _131_PalindromePartitioning();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testPartition1() throws Exception {
        List<List<String>> partition = target.partition("aab");
        assertEquals(2, partition.size());
        assertArrayEquals(new String[]{"a", "a", "b"}, partition.get(0).toArray(new String[0]));
        assertArrayEquals(new String[]{"aa", "b"}, partition.get(1).toArray(new String[0]));
    }

    @Test
    public void testPartition2() throws Exception {
        List<List<String>> partition = target.partition("a");
        assertEquals(1, partition.size());
        assertArrayEquals(new String[]{"a"}, partition.get(0).toArray(new String[0]));
    }

    @Test
    public void testPartition3() throws Exception {
        List<List<String>> partition = target.partition("aabb");
        assertEquals(4, partition.size());
        assertArrayEquals(new String[]{"a", "a", "b", "b"}, partition.get(0).toArray(new String[0]));
        assertArrayEquals(new String[]{"a", "a", "bb"}, partition.get(1).toArray(new String[0]));
        assertArrayEquals(new String[]{"aa", "b", "b"}, partition.get(2).toArray(new String[0]));
        assertArrayEquals(new String[]{"aa", "bb"}, partition.get(3).toArray(new String[0]));
    }

    @Test
    public void testPartition4() throws Exception {
        List<List<String>> partition = target.partition("efe");
        assertEquals(2, partition.size());
        assertArrayEquals(new String[]{"e", "f", "e"}, partition.get(0).toArray(new String[0]));
        assertArrayEquals(new String[]{"efe"}, partition.get(1).toArray(new String[0]));
    }
}
