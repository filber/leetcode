package tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class _1382_BalanceABinarySearchTreeTest {

    _1382_BalanceABinarySearchTree target;

    @Before
    public void setUp() throws Exception {
        target = new _1382_BalanceABinarySearchTree();
    }

    @Test
    public void testBalanceBST1() {
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        three.right = four;
        TreeNode two = new TreeNode(2);
        two.right = three;
        TreeNode one = new TreeNode(1);
        one.right = two;

        TreeNode balancedRoot = target.balanceBST(one);
        assertTrue(balancedRoot.val == 2 || balancedRoot.val == 3);
    }
}