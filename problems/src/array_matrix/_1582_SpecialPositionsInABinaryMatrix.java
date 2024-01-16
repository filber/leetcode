package array_matrix;

//https://leetcode.com/problems/special-positions-in-a-binary-matrix

public class _1582_SpecialPositionsInABinaryMatrix {

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCnt = new int[m];
        int[] colCnt = new int[n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                rowCnt[i] += mat[i][j];
                colCnt[j] += mat[i][j];
            }
        }

        int result = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 1 && rowCnt[i] == 1 && colCnt[j]==1) {
                    result ++;
                }
            }
        }
        return result;
    }
}
