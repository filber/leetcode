// TIPS:
// Using Divide&Conquer and recursion to solve Combinatorics
public class _1863_SumofAllSubsetXORTotals {

    int sum = 0;
    public int subsetXORSum(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }
        dfs(nums, 0, 0);

        return sum;
    }

    public void dfs(int []nums,int i ,int xor_sum){
        if (i==nums.length) {
            sum += xor_sum;
            return;
        }

        // Divide and conquer
        // include current element
        dfs(nums, i + 1, xor_sum ^ nums[i]);
        // exclude current element
        dfs(nums, i + 1, xor_sum);
    }


//    Constraints:
//            1 <= nums.length <= 12
//            1 <= nums[i] <= 20
    public static void main(String[] args) {
        _1863_SumofAllSubsetXORTotals case1 = new _1863_SumofAllSubsetXORTotals();
        int s1 = case1.subsetXORSum(new int[]{1, 3});

        _1863_SumofAllSubsetXORTotals case2 = new _1863_SumofAllSubsetXORTotals();
        int s2 = case2.subsetXORSum(new int[]{5, 1, 6});

        _1863_SumofAllSubsetXORTotals case3 = new _1863_SumofAllSubsetXORTotals();
        int s3 = case3.subsetXORSum(new int[]{3, 4, 5, 6, 7, 8});
    }

}
