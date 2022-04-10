package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1430_CheckIfAStringIsAValidSequenceTest {

    _1430_CheckIfAStringIsAValidSequence target = null;

    @Before
    public void before() throws Exception {
        target = new _1430_CheckIfAStringIsAValidSequence();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testIsValidSequence1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                0,
                1, 0,
                0, 1, 0, null,
                null, 1, 0, 0,
        });
        boolean isValid = target.isValidSequence(root, new int[]{0, 1, 0, 1});
        assertTrue(isValid);
    }

    @Test
    public void testIsValidSequence2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                0,
                1, 0,
                0, 1, 0, null,
                null, 1, 0, 0,
        });
        boolean isValid = target.isValidSequence(root, new int[]{0, 0, 0});
        assertTrue(isValid);
    }

    @Test
    public void testIsValidSequence3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                0,
                1, 0,
                0, 1, 0, null,
                null, 1, 0, 0,
        });
        boolean isValid = target.isValidSequence(root, new int[]{0, 1, 1, 0});
        assertTrue(isValid);
    }

    @Test
    public void testIsValidSequence4() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                0,
                1, 0,
                0, 1, 0, null,
                null, 1, 0, 0,
        });
        boolean isValid = target.isValidSequence(root, new int[]{0, 1, 1});
        assertFalse(isValid);
    }

    @Test
    public void testIsValidSequence5() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{
                0,
                1, 0,
                0, 1, 0, null,
                null, 1, 0, 0,
        });
        boolean isValid = target.isValidSequence(root, new int[]{0, 0});
        assertFalse(isValid);
    }
}
