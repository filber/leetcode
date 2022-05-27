package math;

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

public class _1342_NumberOfStepsToReduceANumberToZero {

    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                num -= 1;
            } else {
                num /= 2;
            }
            count++;
        }
        return count;
    }
}
