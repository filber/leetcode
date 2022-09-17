package stack;

//https://leetcode.com/problems/decode-string/

import java.util.*;

public class _394_DecodeString {

    public String decodeString(String s) {
        int[] idx = new int[s.length()];
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < idx.length; i++) {
            char ch = chars[i];
            if (ch == '[') {
                stack.push(i);
            } else if (ch == ']') {
                int leftIdx = stack.pop();
                idx[i] = leftIdx;
                idx[leftIdx] = i;
            }
        }

        return dfs(s.toCharArray(), idx, 0, idx.length - 1, 1);
    }

    private String dfs(char[] chars, int[] idx, int begin, int end, int multiple) {
        int m = 0;
        List<Character> list = new ArrayList<>();
        int i = begin;
        while (i <= end) {
            char ch = chars[i];
            if (ch >= 'a' && ch <= 'z') {
                if (m == 0) {
                    list.add(ch);
                }
                i++;
            } else if (ch >= '1' && ch <= '9') {
                m = ch - '0';
                while (chars[i + 1] != '[') {
                    m *= 10;
                    m += chars[i + 1] - '0';
                    i++;
                }
                i++;
            } else if (ch == '[') {
                String subStr = dfs(chars, idx, i + 1, idx[i] - 1, m);
                i = idx[i] + 1;
                m = 0;
                for (char c : subStr.toCharArray()) {
                    list.add(c);
                }
            }
        }

        char[] rst = new char[list.size() * multiple];
        int k = 0;
        for (int j = 0; j < multiple; j++) {
            for (int p = 0; p < list.size(); p++) {
                rst[k++] = list.get(p);
            }
        }
        return new String(rst);
    }
}
