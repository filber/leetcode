package tree;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import tree._2227_EncryptAndDecryptStrings.Encrypter;

import static org.junit.Assert.*;

public class _2227_EncryptAndDecryptStringsTest {


    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testEncrypt1() throws Exception {
        char[] keys = {'a', 'b', 'c', 'd'};
        String[] values = {"ei", "zf", "ei", "am"};
        String[] dictionary = {"abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"};
        Encrypter encrypter = new Encrypter(keys, values, dictionary);

        String encrypted = encrypter.encrypt("abcd");
        assertEquals("eizfeiam", encrypted);

        int cnt = encrypter.decrypt("eizfeiam");
        assertEquals(2, cnt);
    }

} 
