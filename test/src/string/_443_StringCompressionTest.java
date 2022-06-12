package string;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.*;

public class _443_StringCompressionTest {

    _443_StringCompression target = null;

    @Before
    public void before() throws Exception {
        target = new _443_StringCompression();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCompress1() throws Exception {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int len = target.compress(chars);
        assertEquals(6, len);
        assertArrayEquals(new char[]{'a', '2', 'b', '2', 'c', '3'}, Arrays.copyOf(chars, len));
    }

    @Test
    public void testCompress2() throws Exception {
        char[] chars = {'a'};
        int len = target.compress(chars);
        assertEquals(1, len);
        assertArrayEquals(new char[]{'a'}, Arrays.copyOf(chars, len));
    }

    @Test
    public void testCompress3() throws Exception {
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int len = target.compress(chars);
        assertEquals(4, len);
        assertArrayEquals(new char[]{'a', 'b', '1', '2'}, Arrays.copyOf(chars, len));
    }
} 
