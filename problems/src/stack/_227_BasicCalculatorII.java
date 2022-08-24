package stack;

//https://leetcode.com/problems/basic-calculator-ii/

public class _227_BasicCalculatorII {

    char[] chars;
    int n;
    int[] operatorS;
    int operatorTop;
    int[] operandS;
    int operandTop;

    public int calculate(String s) {
        init(s);
        int i = 0;
        while (i < n) {
            if (Character.isDigit(chars[i])) {
                int[] conv = convert(i);
                i = conv[0];
                int val = conv[1];
                operandS[++operandTop] = val;
                if (operatorTop >= 0 && (operatorS[operatorTop] == '*' || operatorS[operatorTop] == '/')) {
                    popEvaluate();
                }
            } else if (chars[i] == ' ') {
                // ignore
                i++;
            } else {
                operatorS[++operatorTop] = chars[i];
                i++;
            }
        }

        if (operatorTop > 0) {
            reverse(operatorS, 0, operatorTop);
            reverse(operandS, 0, operandTop);
            while (operatorTop >= 0) {
                popEvaluateReverse();
            }
        } else if (operatorTop == 0) {
            popEvaluate();
        }


        return operandS[operandTop];
    }

    private void init(String s) {
        chars = s.toCharArray();
        n = chars.length;
        operatorS = new int[n];
        operatorTop = -1;
        operandS = new int[n];
        operandTop = -1;
    }

    private int[] convert(int i) {
        int val = 0;
        while (i < n && Character.isDigit(chars[i])) {
            val *= 10;
            val += chars[i] - '0';
            i++;
        }
        return new int[]{i, val};
    }


    private void popEvaluateReverse() {
        int operator = operatorS[operatorTop--];
        int lOperand = operandS[operandTop--];
        int rOperand = operandS[operandTop--];
        int val = evaluate(lOperand, rOperand, operator);
        operandS[++operandTop] = val;
    }
    private void popEvaluate() {
        int operator = operatorS[operatorTop--];
        int rOperand = operandS[operandTop--];
        int lOperand = operandS[operandTop--];
        int val = evaluate(lOperand, rOperand, operator);
        operandS[++operandTop] = val;
    }

    private int evaluate(int l,int r,int operator) {
        int val = 0;
        if (operator == '+') {
            val = l + r;
        } else if (operator == '-') {
            val = l - r;
        } else if (operator == '*') {
            val = l * r;
        } else {
            val = l / r;
        }
        return val;
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
}
