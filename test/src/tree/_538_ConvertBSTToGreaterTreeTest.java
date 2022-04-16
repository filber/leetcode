package tree;

import com.sun.source.tree.Tree;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _538_ConvertBSTToGreaterTreeTest {

    _538_ConvertBSTToGreaterTree target = null;

    @Before
    public void before() throws Exception {
        target = new _538_ConvertBSTToGreaterTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testConvertBST1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                4,
                1, 6,
                0, 2, 5, 7, null, null, null, 3, null, null, null, 8
        });
        root = target.convertBST(root);
        assertArrayEquals(new Integer[]{30, 36, 21, 36, 35, 26, 15, 33, 8}, root.toArray());
    }

    @Test
    public void testConvertBST2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                0, null, 1
        });
        root = target.convertBST(root);
        assertArrayEquals(new Integer[]{1, 1}, root.toArray());
    }

    @Test
    public void testConvertBST3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                3, 2, 4, 1
        });
        root = target.convertBST(root);
        assertArrayEquals(new Integer[]{7, 9, 4, 10}, root.toArray());
    }
}
