package stack;

public class _150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = -1;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    int sum = stack[top] + stack[top - 1];
                    top--;
                    stack[top] = sum;
                    break;
                case "-":
                    int subtraction = stack[top-1] - stack[top];
                    top--;
                    stack[top] = subtraction;
                    break;
                case "*":
                    int multiplication = stack[top-1] * stack[top];
                    top--;
                    stack[top] = multiplication;
                    break;
                case "/":
                    int division = stack[top-1] / stack[top];
                    top--;
                    stack[top] = division;
                    break;
                default:
                    stack[++top] = Integer.parseInt(token);
            }
        }

        return stack[0];
    }
}
