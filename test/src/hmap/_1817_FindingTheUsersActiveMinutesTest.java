package hmap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1817_FindingTheUsersActiveMinutesTest {

    _1817_FindingTheUsersActiveMinutes target = null;

    @Before
    public void before() throws Exception {
        target = new _1817_FindingTheUsersActiveMinutes();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testFindingUsersActiveMinutes1() throws Exception {
        int[][] logs = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int k = 5;
        int[] expected = {0, 2, 0, 0, 0};
        int[] actual = target.findingUsersActiveMinutes(logs, k);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindingUsersActiveMinutes2() throws Exception {
        int[][] logs = {{1, 1}, {2, 2}, {2, 3}};
        int k = 4;
        int[] expected = {1, 1, 0, 0};
        int[] actual = target.findingUsersActiveMinutes(logs, k);
        assertArrayEquals(expected, actual);
    }
}
