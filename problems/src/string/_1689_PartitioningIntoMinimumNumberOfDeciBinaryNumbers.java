package string;

//https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

public class _1689_PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public int minPartitions(String n) {
        char[] chars = n.toCharArray();
        char max = '0';
        for (char ch : chars) {
            if (ch > max) {
                max = ch;
            }
        }
        return max - '0';
    }
}
