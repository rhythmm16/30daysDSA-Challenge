import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    if (stack.size() < 2) throw new IllegalArgumentException("Invalid RPN expression");
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    if (stack.size() < 2) throw new IllegalArgumentException("Invalid RPN expression");
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "-":
                    if (stack.size() < 2) throw new IllegalArgumentException("Invalid RPN expression");
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "/":
                    if (stack.size() < 2) throw new IllegalArgumentException("Invalid RPN expression");
                    int divisor = stack.pop();
                    int dividend = stack.pop();
                    if (divisor == 0) throw new ArithmeticException("Division by zero");
                    stack.push(dividend / divisor);
                    break;
                default:
                    try {
                        stack.push(Integer.parseInt(token));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid token: " + token);
                    }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN expression");
        }
        
        return stack.pop();
    }
}
