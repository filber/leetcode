package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _979_DistributeCoinsInBinaryTreeTest {

    _979_DistributeCoinsInBinaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _979_DistributeCoinsInBinaryTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testDistributeCoins1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 0, 0});
        int moves = target.distributeCoins(root);
        assertEquals(2, moves);
    }

    @Test
    public void testDistributeCoins2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{0, 3, 0});
        int moves = target.distributeCoins(root);
        assertEquals(3, moves);
    }
}