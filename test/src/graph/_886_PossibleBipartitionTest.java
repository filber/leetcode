package graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _886_PossibleBipartitionTest {

    _886_PossibleBipartition target;

    @Before
    public void before() throws Exception {
        target = new _886_PossibleBipartition();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testPossibleBipartition1() throws Exception {
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        // [1,4], [2,3]
        boolean possible = target.possibleBipartition(n, dislikes);
        assertTrue(possible);
    }

    @Test
    public void testPossibleBipartition2() throws Exception {
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        boolean possible = target.possibleBipartition(n, dislikes);
        assertFalse(possible);
    }

    @Test
    public void testPossibleBipartition3() throws Exception {
        int n = 5;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        boolean possible = target.possibleBipartition(n, dislikes);
        assertFalse(possible);
    }
}
