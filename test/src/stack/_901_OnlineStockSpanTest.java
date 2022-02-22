package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

import stack._901_OnlineStockSpan.StockSpanner;

public class _901_OnlineStockSpanTest {

    StockSpanner spanner;

    @Before
    public void before() throws Exception {
        spanner = new StockSpanner();
        ;
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testNext1() throws Exception {
        assertEquals(1, spanner.next(100)); // 1 [100(1)]
        assertEquals(1, spanner.next(80)); // 1 [100(1),80(1)]
        assertEquals(1, spanner.next(60)); // 1 [100(1),80(1),60(1)]
        assertEquals(2, spanner.next(70)); // 2 [100(1),80(1),70(2)]
        assertEquals(1, spanner.next(60)); // 1 [100(1),80(1),70(2),60(1)]
        assertEquals(4, spanner.next(75)); // 4 [100(1),80(1),75(4)]
        assertEquals(6, spanner.next(85)); // 6 [100(1),85(6)]
    }

    @Test
    public void testNext2() throws Exception {
        assertEquals(1, spanner.next(29)); // 1 [29(1)]
        assertEquals(2, spanner.next(91)); // 2 [91(2)]
        assertEquals(1, spanner.next(62)); // 1 [91(2),62(1)]
        assertEquals(2, spanner.next(76)); // 2 [91(2),76(2)]
        assertEquals(1, spanner.next(51)); // 1 [91(2),76(2),51(1)]
    }

    @Test
    public void testNext3() throws Exception {
        assertEquals(1, spanner.next(28)); // 1 [28(1)]
        assertEquals(1, spanner.next(14)); // 1 [28(1),14(1)]
        assertEquals(3, spanner.next(28)); // 2 [28(2)]
    }
}
