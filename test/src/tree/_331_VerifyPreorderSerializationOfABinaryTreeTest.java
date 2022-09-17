package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _331_VerifyPreorderSerializationOfABinaryTreeTest {

    _331_VerifyPreorderSerializationOfABinaryTree target = null;

    @Before
    public void before() throws Exception {
        target = new _331_VerifyPreorderSerializationOfABinaryTree();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testIsValidSerialization1() throws Exception {
        boolean valid = target.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
        assertTrue(valid);
    }

    @Test
    public void testIsValidSerialization2() throws Exception {
        boolean valid = target.isValidSerialization("1,#");
        assertFalse(valid);
    }

    @Test
    public void testIsValidSerialization3() throws Exception {
        boolean valid = target.isValidSerialization("9,#,#,1");
        assertFalse(valid);
    }

    @Test
    public void testIsValidSerialization4() throws Exception {
        boolean valid = target.isValidSerialization("9,#,#");
        assertTrue(valid);
    }

    @Test
    public void testIsValidSerialization5() throws Exception {
        boolean valid = target.isValidSerialization("9,#,#,#");
        assertFalse(valid);
    }

    @Test
    public void testIsValidSerialization6() throws Exception {
        boolean valid = target.isValidSerialization("#");
        assertTrue(valid);
    }

    @Test
    public void testIsValidSerialization7() throws Exception {
        boolean valid = target.isValidSerialization("#,#");
        assertFalse(valid);
    }

    @Test
    public void testIsValidSerialization8() throws Exception {
        boolean valid = target.isValidSerialization("#,9");
        assertFalse(valid);
    }
}
