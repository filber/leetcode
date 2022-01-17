package math;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/

public class _1276_NumberOfBurgersWithNoWasteOfIngredients {

//  Constraints:
//      0 <= tomatoSlices <= 10^7
//      0 <= cheeseSlices <= 10^7

    public static List<Integer> numOfBurgers(int t, int c) {
        int doulbeJ = t - 2 * c;
        int doulbeS = 4 * c - t;
        if (doulbeJ < 0 || doulbeJ % 2 != 0 || doulbeS < 0 || doulbeS % 2 != 0) {
            return new ArrayList<>();
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(doulbeJ / 2);
            list.add(doulbeS / 2);
            return list;
        }
    }

    public static void main(String[] args) {
        // [1,6]
        List l1 = numOfBurgers(16, 7);

        // []
        List l2 = numOfBurgers(17, 4);

        // []
        List l3 = numOfBurgers(4, 17);

        // [0,0]
        List l4 = numOfBurgers(0, 0);

        // [0,1]
        List l5 = numOfBurgers(2, 1);
    }
}
