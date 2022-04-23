package hmap;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _535_EncodeAndDecodeTinyURLTest {

    _535_EncodeAndDecodeTinyURL.Codec target = null;

    @Before
    public void before() throws Exception {
        target = new _535_EncodeAndDecodeTinyURL.Codec();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testCodec1() throws Exception {
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = target.encode(longUrl);
        assertEquals(longUrl, target.decode(shortUrl));
    }

    @Test
    public void testCodec2() throws Exception {
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = target.encode(longUrl);
        assertEquals(shortUrl, target.encode(longUrl));
    }

    @Test
    public void testCodec3() throws Exception {
        String longUrl1 = "https://leetcode.com/problems/design-tinyurl1";
        String longUrl2 = "https://leetcode.com/problems/design-tinyurl2";
        String shortUrl1 = target.encode(longUrl1);
        String shortUrl2 = target.encode(longUrl2);
        assertNotEquals(shortUrl1, shortUrl2);
    }

    @Test
    public void testCodec4() throws Exception {
        String longUrl = "https://leetcode.com/problems/design-tinyurl";
        String shortUrl = target.encode(longUrl);
        String decodedUrl = target.decode(shortUrl + 'a');
        assertNull(decodedUrl);
    }

    @Test
    public void testCodec5() throws Exception {
        String decodedUrl = target.decode(_535_EncodeAndDecodeTinyURL.Codec.PREFIX + "+-+-+-");
        assertNull(decodedUrl);
    }

    @Test
    public void testCodec6() throws Exception {
        String decodedUrl = target.decode(_535_EncodeAndDecodeTinyURL.Codec.PREFIX + "123aBc");
        assertNull(decodedUrl);
    }
}
