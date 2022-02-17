package math;

public class _991_BrokenCalculator {

    //    In one operation, you can:
//        multiply the number by 2, or subtract 1
//    return the minimum number of operations needed to display target on the calculator.
    public int brokenCalc(int startValue, int target) {
        if (startValue >= target) {
            // forward search: all subtract operations
            return startValue - target;
        } else if (target % 2 == 0) {
            // backward search 1: divide target by 2
            return brokenCalc(startValue, target / 2) + 1;
        } else {
            // backward search 2: add target by 1
            return brokenCalc(startValue, target + 1) + 1;
        }
    }
}
