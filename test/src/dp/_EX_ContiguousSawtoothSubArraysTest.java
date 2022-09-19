package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_ContiguousSawtoothSubArraysTest {

    _EX_ContiguousSawtoothSubArrays target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_ContiguousSawtoothSubArrays();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testCount1() throws Exception {
        int[] arr = {9, 8, 7, 6, 5};
        int cnt = target.count(arr);
        // [9,8],[8,7],[7,6],[6,5]
        assertEquals(4, cnt);
    }

    @Test
    public void testCount2() throws Exception {
        int[] arr = {10, 10, 10};
        int cnt = target.count(arr);
        assertEquals(0, cnt);
    }

    @Test
    public void testCount3() throws Exception {
        int[] arr = {1, 2, 1, 2, 1};
        int cnt = target.count(arr);
        // 1  2     1     2     1
        //    2
        // [1,2]
        //          1
        //       [2,1]
        //     [1,2,1]
        //                2
        //             [1,2]
        //           [2,1,2]
        //         [1,2,1,2]
        //                       1
        //                    [2,1]
        //                  [1,2,1]
        //                [2,1,2,1]
        //              [1,2,1,2,1]

        //[1,2],[2,1],[1,2],[2,1] #4
        //[1,2,1],[2,1,2],[1,2,1] #3
        //[1,2,1,2],[2,1,2,1]     #2
        //[1,2,1,2,1]             #1
        assertEquals(10, cnt);
    }
}
