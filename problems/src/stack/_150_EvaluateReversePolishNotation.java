package stack;

public class _150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[n];
        int top = -1;
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int operand2 = stack[top--];
                int operand1 = stack[top--];
                int val = 0;
                switch (token) {
                    case "+":
                        val = operand1 + operand2;
                        break;
                    case "-":
                        val = operand1 - operand2;
                        break;
                    case "*":
                        val = operand1 * operand2;
                        break;
                    case "/":
                        val = operand1 / operand2;
                        break;
                }
                stack[++top] = val;
            } else {
                int val = Integer.parseInt(token);
                stack[++top] = val;
            }
        }
        return stack[top];
    }
}
