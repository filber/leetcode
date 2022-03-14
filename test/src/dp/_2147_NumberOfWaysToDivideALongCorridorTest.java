package dp;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2147_NumberOfWaysToDivideALongCorridorTest {

    _2147_NumberOfWaysToDivideALongCorridor target = null;

    @Before
    public void before() throws Exception {
        target = new _2147_NumberOfWaysToDivideALongCorridor();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testNumberOfWays1() throws Exception {
        int ways = target.numberOfWays("SSPPSPS");
        assertEquals(3, ways);
    }

    @Test
    public void testNumberOfWays2() throws Exception {
        int ways = target.numberOfWays("PPSPSP");
        assertEquals(1, ways);
    }

    @Test
    public void testNumberOfWays3() throws Exception {
        int ways = target.numberOfWays("S");
        assertEquals(0, ways);
    }

    @Test
    public void testNumberOfWays4() throws Exception {
        int ways = target.numberOfWays("PPPPSPPPP");
        assertEquals(0, ways);
    }

    @Test
    public void testNumberOfWays5() throws Exception {
        int ways = target.numberOfWays("SSSSSS");
        assertEquals(1, ways);
    }

    @Test
    public void testNumberOfWays6() throws Exception {
        int ways = target.numberOfWays("SSPPSPSSPPPS");
        assertEquals(3, ways);
    }

    @Test
    public void testNumberOfWays7() throws Exception {
        int ways = target.numberOfWays("PPPSSPPSPSPPPPSPPPS");
        assertEquals(15, ways);
    }

    @Test
    public void testNumberOfWays8() throws Exception {
        int ways = target.numberOfWays("PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPSPPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS");
        assertEquals(18335643, ways);
    }

}
