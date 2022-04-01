package list;

//https://leetcode.com/problems/circular-array-loop/

public class _457_CircularArrayLoop {

    boolean[] visited;
    int[] nums;
    int n;

    public boolean circularArrayLoop(int[] nums) {
        n = nums.length;
        visited = new boolean[n];
        this.nums = nums;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (isValid(i)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(int i) {
        int slow = i;
        int fast = i;
        visited[i] = true;
        do {
            slow = (slow + nums[slow] % n + n) % n;
            visited[slow] = true;
            fast = (fast + nums[fast] % n + n) % n;
            visited[fast] = true;
            fast = (fast + nums[fast] % n + n) % n;
            visited[fast] = true;
        } while (slow != fast);

        int len = 0;
        boolean isPositive = nums[slow] > 0;
        int start = slow;
        do {
            slow = (slow + nums[slow] % n + n) % n;
            len++;
            if (isPositive && nums[slow] < 0 || !isPositive && nums[slow] > 0) {
                return false;
            }
        } while (slow != start);

        return len > 1;
    }
}
