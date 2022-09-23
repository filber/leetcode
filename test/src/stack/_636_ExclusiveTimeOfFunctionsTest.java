package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _636_ExclusiveTimeOfFunctionsTest {

    _636_ExclusiveTimeOfFunctions target;

    @Before
    public void before() throws Exception {
        target = new _636_ExclusiveTimeOfFunctions();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testExclusiveTime1() throws Exception {
        List<String> logs = List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        int n = 2;
        int[] time = target.exclusiveTime(n, logs);
        assertArrayEquals(new int[]{3, 4}, time);
    }

    @Test
    public void testExclusiveTime2() throws Exception {
        List<String> logs = List.of("0:start:0", "0:start:1", "0:start:2", "0:end:3", "0:end:4", "0:end:5");
        int n = 1;
        int[] time = target.exclusiveTime(n, logs);
        assertArrayEquals(new int[]{6}, time);
    }
}
