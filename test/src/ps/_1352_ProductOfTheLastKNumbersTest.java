package ps;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import ps._1352_ProductOfTheLastKNumbers.ProductOfNumbers;

import static org.junit.Assert.*;

public class _1352_ProductOfTheLastKNumbersTest {


    ProductOfNumbers target = null;

    @Before
    public void before() throws Exception {
        target = new ProductOfNumbers();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testProductOfNumbers1() throws Exception {
        target.add(3);
        assertEquals(3, target.getProduct(1));
        target.add(0);
        assertEquals(0, target.getProduct(1));
        assertEquals(0, target.getProduct(2));
        target.add(2);
        target.add(5);
        target.add(4);
        assertEquals(20, target.getProduct(2));
        assertEquals(40, target.getProduct(3));
        assertEquals(0, target.getProduct(4));
        target.add(8);
        assertEquals(32, target.getProduct(2));
    }
}
