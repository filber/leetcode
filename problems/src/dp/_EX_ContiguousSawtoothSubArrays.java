package dp;

public class _EX_ContiguousSawtoothSubArrays {

    public int count(int[] arr) {
        int prevRel = 0; // -1:prev< cur; 0:prev=cur; 1:prev>cur
        int count = 0;
        int len = 0;
        for (int i = 1; i < arr.length; i++) {
            int prev = arr[i - 1];
            int cur = arr[i];
            if (prev == cur) {
                prevRel = 0;
                len = 1;
            } else if (prev < cur) {
                if (prevRel <= 0) {
                    len = 2;
                } else {
                    len += 1;
                }
                prevRel = -1;
            } else {
                if (prevRel >= 0) {
                    len = 2;
                } else {
                    len += 1;
                }
                prevRel = 1;
            }

            count += len - 1;
        }
        return count;
    }
}
