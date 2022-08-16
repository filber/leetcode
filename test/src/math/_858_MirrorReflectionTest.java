package math;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _858_MirrorReflectionTest {

    _858_MirrorReflection target = null;

    @Before
    public void before() throws Exception {
        target = new _858_MirrorReflection();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testMirrorReflection1() throws Exception {
        int receptor = target.mirrorReflection(2, 1);
        assertEquals(2, receptor);
    }

    @Test
    public void testMirrorReflection2() throws Exception {
        int receptor = target.mirrorReflection(3, 1);
        assertEquals(1, receptor);
    }

    @Test
    public void testMirrorReflection3() throws Exception {
        int receptor = target.mirrorReflection(3, 2);
        assertEquals(0, receptor);
    }
}
