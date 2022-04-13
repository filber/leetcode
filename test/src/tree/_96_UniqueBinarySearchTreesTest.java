package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _96_UniqueBinarySearchTreesTest {

    _96_UniqueBinarySearchTrees target = null;

    @Before
    public void before() throws Exception {
        target = new _96_UniqueBinarySearchTrees();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testNumTrees1() throws Exception {
        int num = target.numTrees(1);
        assertEquals(1, num);
    }

    @Test
    public void testNumTrees2() throws Exception {
        int num = target.numTrees(2);
        assertEquals(2, num);
    }

    @Test
    public void testNumTrees3() throws Exception {
        int num = target.numTrees(3);
        assertEquals(5, num);
    }

    @Test
    public void testNumTrees4() throws Exception {
        int num = target.numTrees(4);
        assertEquals(14, num);
    }
}
