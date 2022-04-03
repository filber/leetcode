package list;

//https://leetcode.com/problems/circular-array-loop/

public class _457_CircularArrayLoop {

    boolean[] visited;
    int[] nums;
    int n;

    public boolean circularArrayLoop(int[] nums) {
        this.nums = nums;
        n = nums.length;
        visited = new boolean[n];
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
        int fast = i, slow = i;
        visited[i] = true;
        do {
            slow = next(slow);
            visited[slow] = true;
            fast = next(fast);
            visited[fast] = true;
            fast = next(fast);
            visited[fast] = true;
        } while (fast != slow);

        boolean isPos = nums[slow] > 0;

        int len = 0;
        int base = slow;
        do {
            if (isPos && nums[slow] < 0 ||
                    !isPos && nums[slow] > 0) {
                return false;
            }
            slow = next(slow);
            len++;
        } while (slow != base);

        return len > 1;
    }

    private int next(int pos) {
        pos = (pos + nums[pos] % n + n) % n;
        return pos;
    }

}
