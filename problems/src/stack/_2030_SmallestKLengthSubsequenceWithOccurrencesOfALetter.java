package stack;

//https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/

public class _2030_SmallestKLengthSubsequenceWithOccurrencesOfALetter {

    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        char[] stack = new char[k];
        int top = -1;
        int letterCount = 0;
        for (char ch : arr) {
            letterCount += ch == letter ? 1 : 0;
        }

        int stackLetter = 0; // count of letter in stack
        for (int i = 0; i < arr.length; i++) {
            while (
                // 1. could pop
                    (
                    top >= 0 // stack is not empty
                            && stack[top] > arr[i] // arr[i] is better
                            && n - i + top + 1 > k // have enough remaining chars
                            && stackLetter - (stack[top] == letter ? 1 : 0) + letterCount >= repetition // have enough letters
                    )
                ||
                // 2. must pop
                stackLetter + k - top - 1 < repetition // no enough position for letter
            ) {
                char peek = stack[top];
                top--;
                stackLetter -= peek == letter ? 1 : 0;
            }

            if (top + 1 < k) {
                stackLetter += arr[i] == letter ? 1 : 0;
                stack[++top] = arr[i];
            }

            if (arr[i] == letter) {
                letterCount--; // remaining letter in array
            }
        }

        return new String(stack, 0, top + 1);
    }
}
