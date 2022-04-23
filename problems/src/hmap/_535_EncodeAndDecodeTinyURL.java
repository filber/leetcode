package hmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _535_EncodeAndDecodeTinyURL {

    public static class Codec {

        public static final String PREFIX = "http://tinyurl.com/";
        Random random = new Random();

        private char[] alphanum = new char[62];

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
                    int idx = random.nextInt(alphanum.length);
                    chars[i] = alphanum[idx];
                }
                str = new String(chars);
            }

            return str;
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            String str = encodeMap.get(longUrl);
            if (str == null) {
                str = randomStr();
                encodeMap.put(longUrl, str);
                decodeMap.put(str, longUrl);
            }
            return PREFIX + str;
        }

        Pattern pattern = Pattern.compile(PREFIX + "([a-zA-Z0-9]{6})");

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            Matcher matcher = pattern.matcher(shortUrl);
            if (!matcher.matches()) {
                return null;
            }
            String str = matcher.group(1);
            String longUrl = decodeMap.get(str);
            return longUrl;
        }
    }
}
