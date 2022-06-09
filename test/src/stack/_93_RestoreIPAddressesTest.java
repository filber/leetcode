package stack;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class _93_RestoreIPAddressesTest {

    _93_RestoreIPAddresses target = null;

    @Before
    public void before() throws Exception {
        target = new _93_RestoreIPAddresses();
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testRestoreIpAddresses1() throws Exception {
        List<String> list = target.restoreIpAddresses("25525511135");
        assertEquals(2, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("255.255.11.135"));
        assertTrue(set.contains("255.255.111.35"));
    }

    @Test
    public void testRestoreIpAddresses2() throws Exception {
        List<String> list = target.restoreIpAddresses("0000");
        assertEquals(1, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("0.0.0.0"));
    }

    @Test
    public void testRestoreIpAddresses3() throws Exception {
        List<String> list = target.restoreIpAddresses("101023");
        assertEquals(5, list.size());
        Set<String> set = new HashSet<>(list);
        assertTrue(set.contains("1.0.10.23"));
        assertTrue(set.contains("1.0.102.3"));
        assertTrue(set.contains("10.1.0.23"));
        assertTrue(set.contains("10.10.2.3"));
        assertTrue(set.contains("101.0.2.3"));
    }

    @Test
    public void testRestoreIpAddresses4() throws Exception {
        List<String> list = target.restoreIpAddresses("123");
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRestoreIpAddresses5() throws Exception {
        List<String> list = target.restoreIpAddresses("0");
        assertTrue(list.isEmpty());
    }
}
