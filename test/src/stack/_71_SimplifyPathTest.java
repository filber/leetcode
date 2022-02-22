package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _71_SimplifyPathTest {

    _71_SimplifyPath target = null;

    @Before
    public void before() throws Exception {
        target = new _71_SimplifyPath();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSimplifyPath1() throws Exception {
        String path = target.simplifyPath("//");
        assertEquals("/", path);
    }

    @Test
    public void testSimplifyPath2() throws Exception {
        String path = target.simplifyPath("/");
        assertEquals("/", path);
    }

    @Test
    public void testSimplifyPath3() throws Exception {
        String path = target.simplifyPath("/./");
        assertEquals("/", path);
    }

    @Test
    public void testSimplifyPath4() throws Exception {
        String path = target.simplifyPath("/..");
        assertEquals("/", path);
    }

    @Test
    public void testSimplifyPath5() throws Exception {
        String path = target.simplifyPath("/../");
        assertEquals("/", path);
    }

    @Test
    public void testSimplifyPath6() throws Exception {
        String path = target.simplifyPath("/../home");
        assertEquals("/home", path);
    }

    @Test
    public void testSimplifyPath7() throws Exception {
        String path = target.simplifyPath("/../home/");
        assertEquals("/home", path);
    }

    @Test
    public void testSimplifyPath8() throws Exception {
        String path = target.simplifyPath("/home/../");
        assertEquals("/", path);
    }

    @Test
    public void testSimplifyPath9() throws Exception {
        String path = target.simplifyPath("/home/..");
        assertEquals("/", path);
    }

    @Test
    public void testSimplifyPath10() throws Exception {
        String path = target.simplifyPath("/home/");
        assertEquals("/home", path);
    }

    @Test
    public void testSimplifyPath11() throws Exception {
        String path = target.simplifyPath("/home//foo/");
        assertEquals("/home/foo", path);
    }
}
