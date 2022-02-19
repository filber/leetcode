package array_matrix;

// https://leetcode.com/problems/gas-station/
public class _134_GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int availableGas = 0;
        int totalGas = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            int extra = gas[i] - cost[i];
            availableGas += extra;
            totalGas += extra;
            if (availableGas < 0) {
                availableGas = 0;
                index = i + 1;
            }
        }
        if (totalGas < 0) {
            return -1;
        }
        return index;
    }

    public static void main(String[] args) {
        // 3
//        new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        // -1
//        int p2 = canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
    }
}
