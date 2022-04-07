package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

public class _637_AverageOfLevelsInBinaryTreeTest {

    _637_AverageOfLevelsInBinaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _637_AverageOfLevelsInBinaryTree();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testAverageOfLevels1() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        List<Double> averages = target.averageOfLevels(root);
        assertArrayEquals(new Double[]{3.0, 14.5, 11.0}, averages.toArray(new Double[0]));
    }

    @Test
    public void testAverageOfLevels2() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3, 9, 20, 15, 7});
        List<Double> averages = target.averageOfLevels(root);
        assertArrayEquals(new Double[]{3.0, 14.5, 11.0}, averages.toArray(new Double[0]));
    }

    @Test
    public void testAverageOfLevels3() throws Exception {
        TreeNode root = TreeNode.createTreeNode(new Integer[]{3});
        List<Double> averages = target.averageOfLevels(root);
        assertArrayEquals(new Double[]{3.0}, averages.toArray(new Double[0]));
    }
}
