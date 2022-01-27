package tree;

// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
public class _421_MaximumXOROfTwoNumbersInAnArray {

    // binary trie, where each trie node has only 2 child
    private static class TrieNode {
        // children[0]: represent bit "0" in the binary representation
        // children[1]: represent bit "1" in the binary representation
        private final TrieNode[] children;

        private TrieNode() {
            children = new TrieNode[2];
        }
    }

    public static int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();


        // 1. Construct Trie
        for (int num : nums) {
            TrieNode cur = root;
            for (int i = MAX_BIT; i >= 1; i--) {
                int bit = num >>> (i - 1) & 1;
                if (cur.children[bit] == null) {
                    cur.children[bit] = new TrieNode();
                }
                cur = cur.children[bit];
            }
        }

        int max = Integer.MIN_VALUE;
        // 2. Traverse Trie for max XOR
        for (int num : nums) {
            TrieNode cur = root;
            int sum = 0;
            for (int i = MAX_BIT; i >= 1; i--) {
                int bit = num >>> (i - 1) & 1;
                if (cur.children[bit ^ 1] != null) {
                    sum += 1 << (i - 1);
                    cur = cur.children[bit ^ 1];
                } else {
                    cur = cur.children[bit];
                }
            }
            max = Math.max(max, sum);
            if (max == Integer.MAX_VALUE) {
                return max;
            }
        }

        return max;
    }

    private static final int MAX_BIT = 31;

    public static void main(String[] args) {
        // 13 [5^8]
        int m1 = findMaximumXOR(new int[]{3, 5, 2, 8});

        // 28 [5^25]
        int m2 = findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});

        // 127
        int m3 = findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70});
    }
}
