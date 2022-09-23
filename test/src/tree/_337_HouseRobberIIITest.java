package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _337_HouseRobberIIITest {

    _337_HouseRobberIII target = null;

    @Before
    public void before() throws Exception {
        target = new _337_HouseRobberIII();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testRob1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 2, 3, null, 3, null, 1});
        int amount = target.rob(root);
        //       [3]
        //      /   \
        //     2     3
        //      \     \
        //      [3]   [1]
        // 3+3+1=7
        assertEquals(7, amount);
    }

    @Test
    public void testRob2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 4, 5, 1, 3, null, 1});
        int amount = target.rob(root);
        //         3
        //      /     \
        //    [4]     [5]
        //    / \       \
        //   1   3       1
        // 4+5=9
        assertEquals(9, amount);
    }
}