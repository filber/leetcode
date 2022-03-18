package stack;

import java.util.Stack;

public class _2030_SmallestKLengthSubsequenceWithOccurrencesOfALetter {

    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int letterCount = 0;
        for (char ch : arr) {
            letterCount += ch == letter ? 1 : 0;
        }

        int n = arr.length;

        int curLetter = 0; // count of letter in stack
        for (int i = 0; i < arr.length; i++) {
            while (
                    // 1. could pop
                    (!stack.isEmpty() // stack is not empty
                    && stack.peek() > arr[i] // arr[i] is better
                    && n - i + stack.size() > k // have enough remaining chars
                    && curLetter - (stack.peek() == letter ? 1 : 0) + letterCount >= repetition // have enough letters
                    )
                    ||
                    // 2. must pop
                    curLetter + k - stack.size() < repetition // no enough position for letter
            ) {
                Character pop = stack.pop();
                if (pop == letter) {
                    curLetter--;
                }
            }

            if (stack.size() < k) {
                if (arr[i] == letter) curLetter++;
                stack.push(arr[i]);
            }

            if (arr[i] == letter) {
                letterCount--; // remaining letter in array
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
