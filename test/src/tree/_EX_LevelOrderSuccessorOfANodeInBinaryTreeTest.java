package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _EX_LevelOrderSuccessorOfANodeInBinaryTreeTest {

    _EX_LevelOrderSuccessorOfANodeInBinaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _EX_LevelOrderSuccessorOfANodeInBinaryTree();
    }

    @After
    public void after() throws Exception {
    }

//                  20
//               /      \
//              10       26
//             /  \     /   \
//            4   18   24    27
//               /  \
//              14   19
//             /  \
//            13  15

    TreeNode root = TreeNode.createTreeNode(new Integer[]{20,
            10, 26,
            4, 18, 24, 27,
            null, null, 14, 19, null, null, null, null,
            null, null, null, null, 13, 15
    });

    @Test
    public void testLevelOrderSuccessor1() throws Exception {
        // 24 -> 27
        TreeNode key = root.right.left;
        TreeNode successor = target.levelOrderSuccessor(root, key);
        assertEquals(27, successor.val);
    }

    @Test
    public void testLevelOrderSuccessor2() throws Exception {
        // 4 -> 18
        TreeNode key = root.left.left;
        TreeNode successor = target.levelOrderSuccessor(root, key);
        assertEquals(18, successor.val);
    }

    @Test
    public void testLevelOrderSuccessor3() throws Exception {
        // 27 -> 14
        TreeNode key = root.right.right;
        TreeNode successor = target.levelOrderSuccessor(root, key);
        assertEquals(14, successor.val);
    }

    @Test
    public void testLevelOrderSuccessor4() throws Exception {
        // 15 -> NULL
        TreeNode key = root.left.right.left.right;
        TreeNode successor = target.levelOrderSuccessor(root, key);
        assertNull(successor);
    }

    @Test
    public void testLevelOrderSuccessor5() throws Exception {
        // 20 -> 10
        TreeNode key = root;
        TreeNode successor = target.levelOrderSuccessor(root, key);
        assertEquals(10, successor.val);
    }
}
