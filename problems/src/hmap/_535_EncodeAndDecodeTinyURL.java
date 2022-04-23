package hmap;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class _535_EncodeAndDecodeTinyURL {

    public class Codec {

        Random random = new Random();

        private char[] alphanum = new char[72];

        Map<String, String> encodeMap = new HashMap<>();
        Map<String, String> decodeMap = new HashMap<>();

        public Codec() {
            for (int i = 0; i < 26; i++) {
                alphanum[i] = (char) ('a' + i);
            }
            for (int i = 0; i < 26; i++) {
                alphanum[i + 26] = (char) ('A' + i);
            }
            for (int i = 0; i < 10; i++) {
                alphanum[i + 52] = (char) ('0' + i);
            }
        }

        private String randomStr() {
            String str = null;
            char[] chars = new char[6];
            while (str == null || decodeMap.containsKey(str)) {
                for (int i = 0; i < chars.length; i++) {
                    chars[i] = alphanum[random.nextInt(alphanum.length)];
                }
                str = new String(chars);
            }

            return str;
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String shortUrl = encodeMap.get(longUrl);
            if (shortUrl == null) {
                shortUrl = randomStr();
                encodeMap.put(longUrl, shortUrl);
                decodeMap.put(shortUrl, longUrl);
            }
            return "http://tinyurl.com/" + shortUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String str = shortUrl.substring(shortUrl.length() - 6);
            String longUrl = decodeMap.get(str);
            return longUrl;
        }
    }
}
