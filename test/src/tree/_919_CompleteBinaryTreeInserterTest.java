package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tree._919_CompleteBinaryTreeInserter.CBTInserter;
import static org.junit.Assert.*;

public class _919_CompleteBinaryTreeInserterTest {


    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testInsert1() throws Exception {
        TreeNode tree = TreeNode.createTreeNode(new Integer[]{1,2});
        CBTInserter cBTInserter = new CBTInserter(tree);
        int i1 = cBTInserter.insert(3);  // return 1
        assertEquals(1, i1);
        int i2 = cBTInserter.insert(4);  // return 2
        assertEquals(2, i2);
        TreeNode root = cBTInserter.get_root(); // return [1, 2, 3, 4]
        Integer[] arr = root.toArray();
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, arr);
    }
}
