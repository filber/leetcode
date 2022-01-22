package string;

// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

import java.util.HashMap;

// [Sliding Window],[String]
public class _1876_SubstringsOfSizeThreeWithDistinctCharacters {

    //    Constraints:
//        1 <= s.length <= 100
//        s consists of lowercase English letters.
    public static int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }

        // Init HashMap
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int cnt = 0;
        putToMap(hashMap, s.charAt(0));
        putToMap(hashMap, s.charAt(1));
        putToMap(hashMap, s.charAt(2));
        if (hashMap.size()==3) {
            cnt++;
        }

        for (int i = 1; i <= s.length() - 3; i++) {
            removeFromMap(hashMap, s.charAt(i - 1));
            putToMap(hashMap, s.charAt(i + 2));
            if (hashMap.size() == 3) {
                cnt++;
            }
        }

        return cnt;
    }

    private static void putToMap(HashMap<Character, Integer> hashMap, char ch) {
        Integer cnt = hashMap.get(ch);
        if (cnt == null) {
            hashMap.put(ch, 1);
        } else {
            hashMap.put(ch, cnt + 1);
        }
    }

    private static void removeFromMap(HashMap<Character, Integer> hashMap, char ch) {
        Integer cnt = hashMap.get(ch);
        if (cnt.equals(1)) {
            hashMap.remove(ch);
        } else {
            hashMap.put(ch, cnt - 1);
        }
    }

    public static void main(String[] args) {
        int c1 = countGoodSubstrings("a"); //0
        int c2 = countGoodSubstrings("ab"); // 0
        int c3 = countGoodSubstrings("aaa"); // 0
        int c4 = countGoodSubstrings("aba"); // 0
        int c5 = countGoodSubstrings("abc"); // 1
        int c6 = countGoodSubstrings("xyzzaz"); // 1
        int c7 = countGoodSubstrings("aababcabc"); //4
    }
}