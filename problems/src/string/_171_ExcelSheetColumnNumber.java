package string;

//https://leetcode.com/problems/excel-sheet-column-number/

public class _171_ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int n = columnTitle.length();
        char[] chars = columnTitle.toCharArray();

        int base = 1;
        for (int i = n - 1; i >= 0; i--) {
            char ch = chars[i];
            ans += base * (ch - 'A' + 1);
            base *= 26;
        }

        return ans;
    }
}
