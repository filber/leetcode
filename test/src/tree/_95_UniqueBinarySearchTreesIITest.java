package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _95_UniqueBinarySearchTreesIITest {

    _95_UniqueBinarySearchTreesII target = null;

    @Before
    public void before() throws Exception {
        target = new _95_UniqueBinarySearchTreesII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testGenerateTrees1() throws Exception {
        List<TreeNode> trees = target.generateTrees(1);
        assertEquals(1, trees.size());
        assertEquals(1, trees.get(0).val);
    }

    @Test
    public void testGenerateTrees2() throws Exception {
        List<TreeNode> trees = target.generateTrees(2);
        assertEquals(2, trees.size());

        TreeNode first = trees.get(0);
        assertEquals(1, first.val);
        assertEquals(2, first.right.val);

        TreeNode second = trees.get(1);
        assertEquals(2, second.val);
        assertEquals(1, second.left.val);
    }

    @Test
    public void testGenerateTrees3() throws Exception {
        List<TreeNode> trees = target.generateTrees(3);
        assertEquals(5, trees.size());
    }
}
