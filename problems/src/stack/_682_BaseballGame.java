package stack;

//https://leetcode.com/problems/baseball-game/

public class _682_BaseballGame {

    public int calPoints(String[] ops) {
        int n = ops.length;
        int[] stack = new int[2 * n];
        int top = -1;
        for (int i = 0; i < n; i++) {
            String op = ops[i];
            if ("+".equals(op)) {
                int operand1 = stack[top];
                int operand2 = stack[top - 1];
                stack[++top] = operand1 + operand2;
            } else if ("D".equals(op)) {
                int operand1 = stack[top];
                stack[++top] = operand1 * 2;
            } else if ("C".equals(op)) {
                top--;
            } else {
                stack[++top] = Integer.valueOf(op);
            }
        }

        int score = 0;
        for (int i = 0; i <= top; i++) {
            score += stack[i];
        }
        return score;
    }
}
