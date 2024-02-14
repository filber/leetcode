package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1905_CountSubIslandsTest {

    _1905_CountSubIslands target;

    @Before
    public void setUp() throws Exception {
        target = new _1905_CountSubIslands();
    }

    @Test
    public void testCountSubIslands1() {
        int[][] M1 = {
                {1, 1, 1, 1, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {1, 0, 0, 1, 1, 1},
                {1, 1, 1, 0, 0, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 0}
        };
        int[][] M2 = {
                {1, 1, 1, 1, 0, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0}
        };
        int count = target.countSubIslands(M1, M2);
        assertEquals(0, count);
    }

    @Test
    public void testCountSubIslands2() {
        int[][] M1 = {
                {1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1}
        };
        int[][] M2 = {
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
        };

        int count = target.countSubIslands(M1, M2);
        assertEquals(3, count);
    }

    @Test
    public void testCountSubIslands3() {
        int[][] M1 = {
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1}
        };
        int[][] M2 = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };

        int count = target.countSubIslands(M1, M2);
        assertEquals(2, count);
    }
}