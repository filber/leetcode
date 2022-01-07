package dp;

import java.util.*;

//https://leetcode.com/problems/different-ways-to-add-parentheses/
public class _241_DifferentWaysToAddParentheses {

    private static Map<String, List<Integer>> map = new HashMap<>();

    public static List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) {
            return map.get(input);
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            char operator = input.charAt(i);
            if (operator == '+' || operator == '-' || operator == '*') {
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1));
                for (int left : leftList) {
                    for (int right : rightList) {
                        int value = calculate(left,right,operator);
                        list.add(value);
                    }
                }
            }
        }

        if (list.isEmpty()) {
            list.add(Integer.valueOf(input));
        }

        map.put(input,list);
        return list;
    }

    private static int calculate(
            int left,
            int right,
            char operator) {
        if ('+' == operator) {
            return left + right;
        } else if ('-' == operator) {
            return left - right;
        } else {
            return left * right;
        }
    }

    public static void main(String[] args) {
//        Input: "2-1-1"
//        Output: [0, 2]
//        Explanation:
//        ((2-1)-1) = 0
//        (2-(1-1)) = 2
        diffWaysToCompute("2-1-1");

//        Input: "2*3-4*5"
//        Output: [-34, -14, -10, -10, 10]
//        Explanation:
//        (2*(3-(4*5))) = -34
//        ((2*3)-(4*5)) = -14
//        ((2*(3-4))*5) = -10
//        (2*((3-4)*5)) = -10
//        (((2*3)-4)*5) = 10
        diffWaysToCompute("2*3-4*5");
    }
}
