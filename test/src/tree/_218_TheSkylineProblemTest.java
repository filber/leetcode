package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _218_TheSkylineProblemTest {

    _218_TheSkylineProblem target = null;

    @Before
    public void before() throws Exception {
        target = new _218_TheSkylineProblem();
    }

    @After
    public void after() throws Exception {
    }


    private int[][] parse(List<List<Integer>> list) {
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }

    @Test
    public void testGetSkyline1() throws Exception {
        List<List<Integer>> list = target.getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
        assertArrayEquals(new int[][]{
                {2, 10}, {3, 15}, {7, 12}, {12, 0}, {15, 10}, {20, 8}, {24, 0}
        }, parse(list));
    }

    @Test
    public void testGetSkyline2() throws Exception {
        List<List<Integer>> list = target.getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}});
        assertArrayEquals(new int[][]{
                {0, 3}, {5, 0}
        }, parse(list));
    }
}
