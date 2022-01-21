package greedy;

// https://leetcode.com/problems/gas-station/
public class _134_GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int availableGas = 0;
        int totalGas = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            availableGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
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

    public static int canCompleteCircuitJump(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int volume = 0;
            int pos = i;
            int steps = n;
            while (volume >= 0) {
                int acquire = gas[pos] - cost[pos];
                if (volume + acquire < 0) {
                    if (pos < i) {
                        // pos in the left of i, can't make it a circle
                        return -1;
                    } else {
                        // pos in the right of i, directly move i to pos
                        i = pos;
                        break;
                    }
                } else if (steps == 0) {
                    return i;
                } else {
                    volume += acquire;
                    pos = (pos + 1) % n;
                    steps--;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // 3
        int p1 = canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});

        // -1
        int p2 = canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
    }
}
