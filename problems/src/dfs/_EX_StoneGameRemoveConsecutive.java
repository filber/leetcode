package dfs;

public class _EX_StoneGameRemoveConsecutive {

    public boolean stoneGame(int[] arr) {
        if (arr.length < 2) {
            return false;
        } else if (arr.length == 2) {
            if (arr[0] == arr[1]) {
                return true;
            } else {
                return false;
            }
        }
        int[] nextArr = new int[arr.length - 2];
        for (int i = 0; i < arr.length - 1; i++) {
            if (i < nextArr.length) {
                nextArr[i] = arr[i];
            }

            if (arr[i] == arr[i + 1]) {
                for (int j = i + 2; j < arr.length; j++) {
                    nextArr[j - 2] = arr[j];
                }
                if (!stoneGame(nextArr)) {
                    return true;
                }
            }
        }

        return false;
    }
}
