package dp;

//https://leetcode.com/problems/count-vowels-permutation/

public class _1220_CountVowelsPermutation {

    private static final int modulo = (int) (1e9 + 7);

    public int countVowelPermutation(int n) {
        int aCnt = 1;
        int eCnt = 1;
        int iCnt = 1;
        int oCnt = 1;
        int uCnt = 1;

        for (int i = 1; i < n; i++) {
            int aC = ((iCnt + eCnt) % modulo + uCnt) % modulo;
            int eC = (aCnt + iCnt) % modulo;
            int iC = (eCnt + oCnt) % modulo;
            int oC = iCnt;
            int uC = (iCnt + oCnt) % modulo;

            aCnt = aC;
            eCnt = eC;
            iCnt = iC;
            oCnt = oC;
            uCnt = uC;
        }

        int a_e = (aCnt + eCnt) % modulo;
        int a_e_i = (a_e + iCnt) % modulo;
        int a_e_i_o = (a_e_i + oCnt) % modulo;
        int a_e_i_o_u = (a_e_i_o + uCnt) % modulo;
        return a_e_i_o_u;
    }
}
